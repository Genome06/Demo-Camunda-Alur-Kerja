package com.example.DemoCamundaAlurKerja.utils;

import camundajar.impl.com.google.gson.Gson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sentry.Sentry;

import java.util.Map;
import java.util.logging.Logger;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    /**
     * Serializes an object to its JSON representation as a string.
     *
     * @param object the object to be serialized
     * @return the JSON string representation of the object, or {@code null} if an error occurs during serialization
     */
    public static String serialize(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            Sentry.captureException(e);
            return null;
        }
    }

    /**
     * Deserializes a JSON string to an object of the specified class.
     *
     * @param <E>  the type of the object
     * @param json the JSON string to be deserialized
     * @param cls  the class of the object
     * @return the deserialized object, or {@code null} if an error occurs during deserialization
     */

    public static <E> E deserialize(String json, Class<E> cls) {
        try {
            return objectMapper.readValue(json, cls);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            Sentry.captureException(e);
            return null;
        }
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            return null;
        }
    }

    public static <E> E deserialize(String json, TypeReference<E> typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            Sentry.captureException(e);
            return null;
        }
    }

    public static <E> E deserializeIgnoreUnknown(String json, Class<E> cls) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, cls);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            Sentry.captureException(e);
            return null;
        }
    }

    public static <E> E deserializeIgnoreUnknown(String json, TypeReference<E> typeReference) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            Sentry.captureException(e);
            return null;
        }
    }

    public static <E> E convert(Object map, Class<E> cls) {
        return objectMapper.convertValue(map, cls);
    }

    public static <E> E convert(Object map, TypeReference<E> typeReference) {
        return objectMapper.convertValue(map, typeReference);
    }


    @SuppressWarnings("unchecked")
    public static <T> T[] castToObjectArray(Object[] array, Class<T> clazz) {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(clazz, array.length);
        for (int i = 0; i < array.length; i++) {
//            System.out.println(JsonUtils.serialize(array[i]));
            Gson gson = new Gson();
            result[i] = (T) JsonUtils.deserializeIgnoreUnknown(gson.toJson(array[i]), clazz);
        }
        return result;
    }
}
