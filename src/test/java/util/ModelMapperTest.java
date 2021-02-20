package util;


import com.demo.model.offer.OfferModel;
import com.demo.service.modelmapper.offer.OfferModelMapper;
import com.demo.util.ModelUtils;
import org.junit.*;

public class ModelMapperTest {

	private static OfferModel offerModel = new OfferModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		offerModel.setCanceled(Boolean.FALSE);
		offerModel.setDescription("Test");
		offerModel.setCurrency("$");
		offerModel.setPrice(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToModelMapping() throws Exception {

		com.demo.service.persistence.domain.offer.Offer offer =
				ModelUtils.toDomain(offerModel, OfferModelMapper.class);
		Assert.assertNotNull(offer);
	}


}