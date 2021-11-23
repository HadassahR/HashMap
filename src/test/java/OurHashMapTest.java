import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void getNull() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when

        // then
        assertNull(map.get("ENGLISH1"));
    }

    @Test
    void put() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RUSSIAN", "PRIVIT");
        map.put("JAPANESE", "NE HOW");
        map.put("MANDARIN", "CONICHIWA");

        // then
        assertEquals("HELLO", map.get("ENGLISH1"));
        assertEquals("HI", map.get("ENGLISH2"));
        assertEquals("HEY", map.get("ENGLISH3"));
        assertEquals("HOLA", map.get("SPANISH"));
        assertEquals("SHALOM", map.get("HEBREW"));
        assertEquals("BONJOUR", map.get("FRENCH"));
        assertEquals("PRIVIT", map.get("RUSSIAN"));
        assertEquals("NE HOW", map.get("JAPANESE"));
        assertEquals("CONICHIWA", map.get("MANDARIN"));
    }

    @Test
    void putSameKeys() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("ENGLISH1", "HI");

        // then
        assertEquals("HI", map.get("ENGLISH1"));
    }

    @Test
    void size() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");

        // then
        assertEquals(3, map.size());
    }

    @Test
    void isEmpty () {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when

        // then
        assertEquals(true, map.isEmpty());
    }

    @Test
    void clear() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");
        map.clear();

        // then
        assertEquals(0, map.size());
    }

    @Test
    void containsKey() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RUSSIAN", "PRIVIT");
        map.put("JAPANESE", "NE HOW");
        map.put("MANDARIN", "CONICHIWA");

        // then
        assertTrue(map.containsKey("RUSSIAN"));
        assertFalse(map.containsKey("ENGLISH"));
    }

    @Test
    void containsValue() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("HEBREW", "SHALOM");

        // then
        assertTrue(map.containsValue("SHALOM"));
        assertFalse(map.containsValue("GOODBYE"));
    }

    @Test
    void remove() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("HEBREW", "SHALOM");
        map.put("ENGLISH", "HI");
        String removed = map.remove("ENGLISH");

        // then
        assertEquals(removed, "HI");
        assertTrue(map.containsKey("HEBREW"));
        assertFalse(map.containsKey("ENGLISH"));
        assertFalse(map.containsValue("HI"));
    }

    @Test
    void keySet() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH", "HEY");
        map.put("ENGLISH", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");

        Set keySet = map.keySet();

        // then
        assertEquals(4, keySet.size());
        assertTrue(keySet.contains("ENGLISH"));
        assertFalse(keySet.contains("HEY"));
    }
    
    @Test
    void values () {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH", "HEY");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RANDOM", "HOLA");

        Collection values = map.values();

        // then
        assertEquals(5, values.size());
        assertTrue(values.contains("SHALOM"));
        assertFalse(values.contains("HEBREW"));
    }

    @Test
    void putALl() {
        // given
        Map<String, String> expectedMap = new HashMap<>();
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        expectedMap.put("ENGLISH", "HELLO");
        expectedMap.put("HEBREW", "SHALOM");
        expectedMap.put("SPANISH", "HOLA");
        map.putAll(expectedMap);

        // then
        assertEquals(expectedMap, map);
    }
}