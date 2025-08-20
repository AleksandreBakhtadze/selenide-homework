package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class SwoopDataSupplier {

    @DataProvider(name = "offersData")
    public Object[][] getOffersData() {
        return new Object[][] {
                {"კარტინგით რბოლა" , 25},
                {"საცხენოსნო კლუბი ბათუმში",24},
                {"საცხენოსნო ტურები და საცხენოსნო გაკვეთილები" , 49},
                {"2 საათიანი კვადრო ტური ბორჯომში 4 ადამიანზე",300},
                {"პინგ-პონგ ბარის 1 თვიანი აბონემენტი",90},
                {"იოგას 1 თვიანი აბონემენტი 12 გაკვეთილი",150},
                {"იოგასა და პილატესის კომბინირებული ერთ თვიანი კურსი",150},
                {"პილატესის 1 თვიანი კურსი ",150},
                {"მთის კარტინგი გუდაურში",50},
                {"პარაპლანით ფრენა",400}
        };
    }

    @DataProvider(name = "getPagesData")
    public Object[][] getPagesData() {
        return new Object[][] {
                {"/category/636/sabavshvo/"},
                {"/category/15/kveba/"},
                {"/category/110/sporti/"}
        };
    }
}