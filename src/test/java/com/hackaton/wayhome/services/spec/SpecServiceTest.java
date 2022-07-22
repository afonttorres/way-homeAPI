package com.hackaton.wayhome.services.spec;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.Housing;
import com.hackaton.wayhome.models.Seller;
import com.hackaton.wayhome.models.Spec;
import com.hackaton.wayhome.models.User;
import com.hackaton.wayhome.repositories.IHousingRepository;
import com.hackaton.wayhome.repositories.ISpecRepository;
import com.hackaton.wayhome.services.housing.HousingService;
import com.hackaton.wayhome.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class SpecServiceTest {

    @Mock
    ISpecRepository specRepository;
    @Mock
    IHousingRepository housingRepository;

    @Test
    void getAllShouldReturnAllSpecsMappedToSpecResDto() {
        int n = 15;
        var service = new SpecService(specRepository, housingRepository);
        var specs = this.createSpecs(n);
        Mockito.when(specRepository.findAll()).thenReturn(specs);
        var sut = service.getAll();
        assertThat(sut.size(), equalTo(n));
        assertThat(sut.get(0).getSpec(), equalTo(specs.get(0).getSpec()));
    }

    @Test
    void getByHousingIdShouldReturnHousingSpecsMappedToSpecResDtoByHousingId() {
        int n = 30;
        var service = new SpecService(specRepository, housingRepository);
        var housing = this.createHousing(1L);
        var specs = this.createSpecs(n);
        Mockito.when(housingRepository.findById(any(Long.class))).thenReturn(Optional.of(housing));
        Mockito.when(specRepository.findByHousingId(any(Long.class))).thenReturn(specs);
        var sut = service.getByHousingId(1L);
        assertThat(sut.size(), equalTo(specs.size()));
        assertThat(sut.get(0).getSpec(), equalTo(specs.get(0).getSpec()));
    }

    @Test void getByHousingIdShouldReturnHousingSpecsAndThrowsException(){
        int n = 30;
        var service = new SpecService(specRepository, housingRepository);
        var specs = this.createSpecs(n);
        Mockito.when(specRepository.findByHousingId(any(Long.class))).thenReturn(specs);
        Exception ex = assertThrows(NotFoundException.class, () -> {
            service.getByHousingId(1L);
        });
        String msg = "Housing Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    private Housing createHousing(Long id){
        var housing = new Housing();
        var seller = this.createSeller(id);
        housing.setTitle("title");
        housing.setDescription("desc");
        housing.setCategory("cat");
        housing.setActive(true);
        housing.setImgUrl1("img");
        housing.setImgUrl2("img");
        housing.setImgUrl3("img");
        housing.setLocation("loc");
        housing.setRatio(4);
        housing.setPrice(400D);
        housing.setPublisher(seller);
        housing.setId(id);
        return housing;
    }

    private Seller createSeller(Long id){
        var seller = new Seller();
        seller.setName("name");
        seller.setUsername("username");
        seller.setEmail("email");
        seller.setAvatarUrl("avatar");
        seller.setLocation("loc");
        seller.setId(id);
        return seller;
    }

    private Spec createSpec(Long id){
        var housing = this.createHousing(1L);
        var spec = new Spec();
        spec.setSpec("spec");
        spec.setHousing(housing);
        spec.setId(id);
        return spec;
    }

    private List<Spec> createSpecs(int n){
        List<Spec> specs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            specs.add(this.createSpec(Long.valueOf(i)));
        }
        return specs;
    }
}