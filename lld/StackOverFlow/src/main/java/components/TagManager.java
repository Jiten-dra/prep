package components;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TagManager {
    Map<String, Tag> tags;
    List<Tag> frequentTags;
    final int MAX_FREQUENT_TAGS;

    //singleton pattern
    static TagManager tagManager;
    static TagManager getInstance() {
        if(tagManager == null) {
            tagManager = new TagManager();
        }
        return tagManager;
    }

    public TagManager() {
        tags = new HashMap<>();
        frequentTags = new ArrayList<>();
        MAX_FREQUENT_TAGS = 10;
    }

    public TagManager(int maxFreq) {
        tags = new HashMap<>();
        frequentTags = new ArrayList<>();
        MAX_FREQUENT_TAGS = maxFreq;
    }
    public Tag getOrCreateTag(String name) {
        Tag tag;
        if(tags.containsKey(name)) {
            tag = tags.get(name);
        }else{
            tag = new Tag(name);
            tags.put(name, tag);
        }
        tag.incrementCount();
        updateFrequentTags(tag);
        return tag;
    }

    private void updateFrequentTags(Tag tag) {
        if(!frequentTags.contains(tag)) {
            frequentTags.add(tag);
        }
        Collections.sort(frequentTags, (a, b) -> b.getCount() - a.getCount());

        if(frequentTags.size() > MAX_FREQUENT_TAGS) {
            //checking and removing every time so length will not be more than MAX_FREQUENT_TAGS
            frequentTags.remove(MAX_FREQUENT_TAGS);
        }
    }

    public List<Tag> getFrequentTags() {
        return frequentTags;
    }

    public void deleteTag(Tag tag) {
        tag = null;
    }
}
