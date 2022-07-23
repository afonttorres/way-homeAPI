package com.hackaton.wayhome.services.housing;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.housing.Housing;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.repositories.IHousingRepository;
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
class HousingServiceTest {

    @Mock
    IHousingRepository housingRepository;

    @Test
    void getAllShouldReturnAllHousings() {
        int n = 5;
        var service = new HousingService(housingRepository);
        var housings = this.createHousings(n);
        Mockito.when(service.getAll()).thenReturn(housings);
        var sut = service.getAll();
        assertThat(sut.size(), equalTo(n));

    }

    @Test
    void getByIdShouldReturnHousingByPamId() {
        var service = new HousingService(housingRepository);
        var housing = this.createHousing(1L);
        System.out.println(housing);
        Mockito.when(housingRepository.findById(any(Long.class))).thenReturn(Optional.of(housing));
        var sut = service.getById(1L);
        System.out.println(sut.getId());
        assertThat(sut.getId(), equalTo(1L));
    }

    @Test
    void getByIdShouldntReturnHousingByPamIdIfHousingDoesntExistAndThrowsEx() {
        var service = new HousingService(housingRepository);
        Exception ex = assertThrows(NotFoundException.class, ()->{
            service.getById(1L);
        });
        String msg = "Housing Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    @Test
    void findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase() {
        var service = new HousingService(housingRepository);
        int n = 8;
        String search = "desc";
        List<Housing> housings = this.createHousings(n);
        Mockito.when(service.findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(any(String.class))).thenReturn(housings);
        var sut = service.findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(search);
        assertThat(sut.size(), equalTo(n));
    }

    private List<Housing> createHousings(int n){
        List<Housing> housings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            housings.add(this.createHousing(Long.valueOf(i)));
        }
        return housings;
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

    private Publisher createSeller(Long id){
        var seller = new Publisher();
        seller.setName("name");
        seller.setUsername("username");
        seller.setEmail("email");
        seller.setAvatarUrl("avatar");
        seller.setLocation("loc");
        seller.setId(id);
        return seller;
    }
}