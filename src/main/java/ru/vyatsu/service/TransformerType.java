package ru.vyatsu.service;

import ru.vyatsu.service.converters.JSONtoXMLTransformer;
import ru.vyatsu.service.converters.XMLtoJSONTransformer;
import ru.vyatsu.service.structure.CarshopJSON;
import ru.vyatsu.service.structure.CarshopXML;

/**
 * Enum определяет возможные типы трансформеров и их соответствующие методы преобразования
 */
public enum TransformerType {
    XMLTOJSON {
        @Override
        public Object transform(Object input) {
            return XMLtoJSONTransformer.transform((CarshopXML) input);
        }
    },
    JSONTOXML {
        @Override
        public Object transform(Object input) {
            return JSONtoXMLTransformer.transform((CarshopJSON) input);
        }
    };

    public abstract Object transform(Object input);
}