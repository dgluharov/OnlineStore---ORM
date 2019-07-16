import OnlineStore.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

//
//            session.beginTransaction();
//            Vendors newVendor = new Vendors();
//            newVendor.setName("Gosho");
//            session.save(newVendor);
//            Products product = new Products();
//            product.setName("Egg");
//            product.setAvailableQuantity(20);
//            product.setDiscount( new BigDecimal(0));
//            product.setSinglePrice(new BigDecimal(0.5));
//            product.setVat(new BigDecimal(20));
//            product.setVendorId(newVendor.getId());
//            session.save(product);
//            session.getTransaction().commit();


//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);


//            session.beginTransaction();
//            FacadeSession session1 = FacadeSession.getSession();
//            Vendors vendor = session1.insertVendor("Ultra21");
//            session.save(vendor);
//            Products product = session1.insertProduct(
//                    "Bike21",
//                    10,
//                    new BigDecimal(500),
//                    new BigDecimal(20),
//                    new BigDecimal(5),
//                    vendor);
//
//            session.save(product);
//            session.getTransaction().commit();

//            session.beginTransaction();
//            FacadeSession session1 = FacadeSession.getSession();
//            Products products = session1.insertProduct("HT1",
//                    25,
//                    new BigDecimal(700),
//                    new BigDecimal(20),
//                    new BigDecimal(5),
//                    session1.insertVendor("RAM"));
//            session.save(products);

//            session.beginTransaction();
////            FacadeSession session1 = FacadeSession.getSession();
////            Vendors vendor = session1.insertVendor("Izida");
////            vendor.getProductsList().add(session1.insertProduct("Chocolate",
////                    100,
////                    new BigDecimal(1),
////                    new BigDecimal(20),
////                    new BigDecimal(0), null
////            ));
////            session.save(vendor);
////            session.getTransaction().commit();

//            session.beginTransaction();
//            FacadeSession session1 = FacadeSession.getSession();
//            Commands command = session1.insertCommads("Walk",
//                    session1.insertState("Fast"));
//            session.save(command);
//            session.getTransaction().commit();

//            session.beginTransaction();
//////            FacadeSession session1 = FacadeSession.getSession();
//////            Customers customer = session1.insertCustomer("Boris",
//////                    "boris@mail.com",false, new BigDecimal(25));
//////            session.save(customer);
//////            session.getTransaction().commit();
//            session.beginTransaction();
//                FacadeSession session1 = FacadeSession.getSession();
//                Orders orders = session1.insertOrder(new Timestamp(System.currentTimeMillis()),
//                        new BigDecimal(20),true, new Currencies(),
//                        new Customers(),new DeliveryType(), new PaymentType());
//                session.getTransaction().commit();

            session.beginTransaction();
            FacadeSession session1 = FacadeSession.getSession();
            ProductType productType = session1.insertProductType("bicycle");
            productType.getProductsSet().add(session1.insertProduct("Ransom",
                    60, new BigDecimal(700),
                    new BigDecimal(20), new BigDecimal(0),
                    session1.insertVendor("Scott")));
            session.save(productType);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
