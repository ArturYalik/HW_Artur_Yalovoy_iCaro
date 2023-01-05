package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProviderData {
    @DataProvider
    public Iterator<Object[]> loginModelDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("asd@gmail.com").withPassword("Qwerty1699!")});

        list.add(new Object[]{new User().withEmail("asd@gmail.com").withPassword("Qwerty1699!")});

        list.add(new Object[]{new User().withEmail("asd@gmail.com").withPassword("Qwerty1699!")});

        list.add(new Object[]{new User().withEmail("asd@gmail.com").withPassword("Qwerty1699!")});

        list.add(new Object[]{new User().withEmail("asd@gmail.com").withPassword("Qwerty1699!")});


        return list.iterator();
    }


}
