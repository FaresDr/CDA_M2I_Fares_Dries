import org.example.Product;
import org.example.Shop;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    Product product;
    Shop shop;

    @Test
    public void When_Update_Then_Quality_Decrease(){
        product = new Product("Chocolat","Milka",10,10);
        shop = new Shop();
        shop.update(product);
        Product expected = new Product("Chocolat","Milka",9,9);
        Assert.assertEquals(expected.getQuality(),product.getQuality());

    }
    @Test
    public void When_Update_Then_Sellin_Decrease(){
        product = new Product("Chocolat","Milka",10,10);
        shop = new Shop();
        shop.update(product);
        Product expected = new Product("Chocolat","Milka",9,9);
        Assert.assertEquals(expected.getSellin(),product.getQuality());
    }
    @Test
    public void When_Update_Then_Quality_Decrease_If_Not_Equal_0(){
        product = new Product("Chocolat","Milka",10,0);
        shop = new Shop();
        shop.update(product);
        Product expected = new Product("Chocolat","Milka",9,0);
        Assert.assertEquals(expected.getQuality(),product.getQuality());

    }
    @Test
    public void When_Update_Then_Sellin_Decrease_If_Not_Equal_0(){
        product = new Product("Chocolat","Milka",0,10);
        shop = new Shop();
        shop.update(product);
        Product expected = new Product("Chocolat","Milka",0,9);
        Assert.assertEquals(expected.getSellin(),product.getSellin());
    }
}
