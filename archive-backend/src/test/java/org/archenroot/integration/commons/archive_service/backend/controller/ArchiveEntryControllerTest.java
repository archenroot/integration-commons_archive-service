package org.archenroot.integration.commons.archive_service.backend.controller;


import org.archenroot.integration.commons.archive_service.backend.domain.entity.ArchiveConfiguration;
import org.archenroot.integration.commons.archive_service.backend.repository.ArchiveConfigurationRepository;
import org.archenroot.integration.commons.archive_service.backend.repository.ArchiveGlobalConfigurationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by zangetsu on 10/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonArchiveServiceApplication.class)
//@WebAppConfiguration
public class ArchiveEntryControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private String userName = "bdussault";

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private ArchiveConfiguration archiveEntry;

    //private List<Bookmark> bookmarkList = new ArrayList<>();

    @Autowired
    private ArchiveGlobalConfigurationRepository archiveGlobalConfigurationRepository;
    @Autowired
    private ArchiveConfigurationRepository archiveConfigurationRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //@Autowired
    //private AccountRepository accountRepository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
/*
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.archiveEntryRepository.deleteAllInBatch();

        //this.accountRepository.deleteAllInBatch();
        // Simplest scenario. Will delegate to Podam all decisions
        PodamFactory factory = new PodamFactoryImpl();

// This will use constructor with minimum arguments and
// then setters to populate POJO
        ArchiveEntry archiveEntryMini = factory.manufacturePojo(ArchiveEntry.class);

// This will use constructor with maximum arguments and
// then setters to populate POJO
        ArchiveEntry archiveEntryMax = factory.manufacturePojoWithFullData(ArchiveEntry.class);


        ArchiveConfiguration archiveGlobalConfiguration = factory.manufacturePojoWithFullData(ArchiveConfiguration.class);
        archiveEntryMax.setArchiveMultiLevelConfiguration(archiveGlobalConfiguration);

        this.archiveEntry = archiveEntryRepository.save(archiveEntryMax);
        //this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + userName, "A description")));
        //this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + userName, "A description")));
    }
*/
    @Test
    public void userNotFound() throws Exception {
        /*
        mockMvc.perform(post("/archive-entries/")
                .content(this.json(new ArchiveEntry()))
                .contentType(contentType))
                .andExpect(status().isNotFound());
                */
    }
/*
    @Test
    public void readSingleBookmark() throws Exception {
        mockMvc.perform(get("/" + userName + "/bookmarks/"
                + this.bookmarkList.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.bookmarkList.get(0).getId().intValue())))
                .andExpect(jsonPath("$.uri", is("http://bookmark.com/1/" + userName)))
                .andExpect(jsonPath("$.description", is("A description")));
    }

    @Test
    public void readBookmarks() throws Exception {
        mockMvc.perform(get("/" + userName + "/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.bookmarkList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" + userName)))
                .andExpect(jsonPath("$[0].description", is("A description")))
                .andExpect(jsonPath("$[1].id", is(this.bookmarkList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].uri", is("http://bookmark.com/2/" + userName)))
                .andExpect(jsonPath("$[1].description", is("A description")));
    }

    @Test
    public void createBookmark() throws Exception {
        String bookmarkJson = json(new Bookmark(
                this.account, "http://spring.io", "a bookmark to the best resource for Spring news and information"));

        this.mockMvc.perform(post("/" + userName + "/bookmarks")
                .contentType(contentType)
                .content(bookmarkJson))
                .andExpect(status().isCreated());
    }
    */

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
