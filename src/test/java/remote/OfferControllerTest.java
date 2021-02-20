package remote;

import com.demo.model.offer.OfferModel;
import org.junit.*;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Date;

public class OfferControllerTest {


    private static OfferModel offerModel;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        offerModel = new OfferModel();
        offerModel.setCanceled(Boolean.FALSE);
        offerModel.setDescription("Test");
        offerModel.setCurrency("$");
        offerModel.setExpirationDate(new Date());
        offerModel.setPrice(3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testList(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ws/v1/offer/list");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(new String(), headers);
        ResponseEntity<OfferModel[]> response =
                restTemplate.exchange(builder.build().encode().toUriString(), HttpMethod.GET, entity, OfferModel[].class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testCreate(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ws/v1/offer/add");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(offerModel.toString(), headers);
        ResponseEntity<OfferModel> response =
                restTemplate.exchange(builder.build().encode().toUriString(), HttpMethod.POST, entity, OfferModel.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ws/v1/offer/update/1");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(offerModel.toString(), headers);
        ResponseEntity<OfferModel> response =
                restTemplate.exchange(builder.build().encode().toUriString(), HttpMethod.PUT, entity, OfferModel.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void testCancel(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ws/v1/offer/cancel/1");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(new String(), headers);
        ResponseEntity<OfferModel> response =
                restTemplate.exchange(builder.build().encode().toUriString(), HttpMethod.PUT, entity, OfferModel.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


}
