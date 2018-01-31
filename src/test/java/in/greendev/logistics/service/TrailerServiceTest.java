package in.greendev.logistics.service;

import in.greendev.logistics.feature.trailer.ITrailerDao;
import in.greendev.logistics.feature.trailer.ITrailerService;
import in.greendev.logistics.feature.trailer.TrailerService;
import in.greendev.logistics.model.Trailer;
import in.greendev.logistics.util.TestEntityProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:test.properties")
public class TrailerServiceTest {

    @Mock
    private ITrailerDao trailerDao;

    private ITrailerService trailerService;

    @Before
    public void setUpMock(){
        MockitoAnnotations.initMocks(this);
        trailerService = new TrailerService(trailerDao);
    }

    @Test
    public void shouldFindAll(){
        Mockito.when(trailerDao.findAll()).thenReturn(TestEntityProvider.TRAILERS);
        final List<Trailer> trailers = trailerService.findAll();
        Mockito.verify(trailerDao).findAll();
        Assert.assertEquals(TestEntityProvider.TRAILERS.size(), trailers.size());
    }

    @Test
    public void shouldBePageable(){
        Mockito.when(trailerDao.findAll(TestEntityProvider.pageRequest)).thenReturn(TestEntityProvider.TRAILERS_PAGE);
        final Page<Trailer> trailerPage = trailerService.listAllByPage(TestEntityProvider.pageRequest);
        Mockito.verify(trailerDao).findAll(TestEntityProvider.pageRequest);
        Assert.assertEquals(TestEntityProvider.TRAILER_PAGE.getTotalPages(), trailerPage.getTotalPages());
        Assert.assertEquals(TestEntityProvider.TRAILER_PAGE.getTotalElements(), trailerPage.getTotalElements());
    }

    @Test
    public void shouldGetOne(){
        Mockito.when(trailerDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.TRAILER1);
        final Trailer trailer = trailerService.getOne(Matchers.anyLong());
        Mockito.verify(trailerDao).getOne(Matchers.anyLong());
        Assert.assertEquals(TestEntityProvider.TRAILER1.getName(), trailer.getName());
    }

    @Test
    public void shouldDelete(){
        Mockito.doNothing().when(trailerDao).delete(Matchers.any(Trailer.class));
        trailerService.delete(TestEntityProvider.TRAILER1);
        Mockito.verify(trailerDao).delete(Matchers.any(Trailer.class));
    }

    @Test
    public void shouldDeleteById(){
        Mockito.doNothing().when(trailerDao).delete(Matchers.anyLong());
        trailerService.deleteById(Matchers.anyLong());
        Mockito.verify(trailerDao).delete(Matchers.anyLong());
    }

    @Test
    public void shouldSave(){
        Mockito.when(trailerDao.save(TestEntityProvider.TRAILER1)).thenReturn(TestEntityProvider.TRAILER1);
        trailerService.save(TestEntityProvider.TRAILER1);
        Mockito.verify(trailerDao).save(TestEntityProvider.TRAILER1);
    }
}
