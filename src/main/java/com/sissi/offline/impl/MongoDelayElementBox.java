package com.sissi.offline.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sissi.config.MongoConfig;
import com.sissi.context.JID;
import com.sissi.offline.DelayElement;
import com.sissi.offline.DelayElementBox;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-11-15
 */
public class MongoDelayElementBox implements DelayElementBox {

	private final Log log = LogFactory.getLog(this.getClass());

	private final String baseTo = "to";

	private final MongoConfig config;

	private final List<DelayElement> elements;

	public MongoDelayElementBox(MongoConfig config, List<DelayElement> elements) {
		super();
		this.config = config;
		this.elements = elements;
	}

	@Override
	public List<Element> pull(JID jid) {
		DBObject query = BasicDBObjectBuilder.start().add(this.baseTo, jid.asStringWithBare()).get();
		this.log.debug("Query: " + query);
		Elements elements = new Elements(this.config.collection().find(query));
		this.config.collection().remove(query);
		return elements;
	}

	@Override
	public DelayElementBox push(Element element) {
		for (DelayElement delay : this.elements) {
			if (delay.isSupport(element)) {
				DBObject entity = BasicDBObjectBuilder.start(delay.write(element)).get();
				this.log.info("Entity: " + entity);
				this.config.collection().save(entity);
			}
		}
		return this;
	}

	private class Elements extends ArrayList<Element> {

		private final static long serialVersionUID = 1L;

		public Elements(DBCursor cursor) {
			super();
			while (cursor.hasNext()) {
				BasicDBObject each = BasicDBObject.class.cast(cursor.next());
				for (DelayElement element : MongoDelayElementBox.this.elements) {
					if (element.isSupport(each)) {
						this.add(element.read(each));
					}
				}
			}
		}
	}
}
