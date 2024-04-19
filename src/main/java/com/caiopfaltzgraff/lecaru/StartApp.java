package com.caiopfaltzgraff.lecaru;

import com.caiopfaltzgraff.lecaru.domain.category.Category;
import com.caiopfaltzgraff.lecaru.domain.product.Product;
import com.caiopfaltzgraff.lecaru.domain.subcategory.Subcategory;
import com.caiopfaltzgraff.lecaru.domain.unit.Address;
import com.caiopfaltzgraff.lecaru.domain.unit.Unit;
import com.caiopfaltzgraff.lecaru.repository.CategoryRepository;
import com.caiopfaltzgraff.lecaru.repository.ProductRepository;
import com.caiopfaltzgraff.lecaru.repository.SubcategoryRepository;
import com.caiopfaltzgraff.lecaru.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class StartApp implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final ProductRepository productRepository;
    private final UnitRepository unitRepository;

    @Override
    public void run(String... args) throws Exception {
        // Categorias
        Category carnes = categoryRepository.save(new Category(null, "Carnes"));
        Category petiscos = categoryRepository.save(new Category(null, "Petiscos"));
        Category massas = categoryRepository.save(new Category(null, "Massas"));
        Category guarnicoes = categoryRepository.save(new Category(null, "Guarnições"));
        Category bebidas = categoryRepository.save(new Category(null, "Bebidas"));
        Category sobremesas = categoryRepository.save(new Category(null, "Sobremesas"));

        // Subcategorias
        Subcategory carnesBovinas = subcategoryRepository.save(new Subcategory(null, "Carnes Bovinas", carnes));
        Subcategory carnesSuinas = subcategoryRepository.save(new Subcategory(null, "Carnes Suinas", carnes));
        Subcategory pasteis = subcategoryRepository.save(new Subcategory(null, "Pastéis", petiscos));
        Subcategory batataFrita = subcategoryRepository.save(new Subcategory(null, "Batata Frita", petiscos));
        Subcategory lasanhas = subcategoryRepository.save(new Subcategory(null, "Lasanhas", massas));
        Subcategory macarrao = subcategoryRepository.save(new Subcategory(null, "Macarrão", massas));
        Subcategory arroz = subcategoryRepository.save(new Subcategory(null, "Arroz", guarnicoes));
        Subcategory farofa = subcategoryRepository.save(new Subcategory(null, "Farofa", guarnicoes));
        Subcategory refrigerantes = subcategoryRepository.save(new Subcategory(null, "Refrigerantes", bebidas));
        Subcategory sucos = subcategoryRepository.save(new Subcategory(null, "Sucos", bebidas));
        Subcategory sorvetes = subcategoryRepository.save(new Subcategory(null, "Sorvetes", sobremesas));
        Subcategory chocolate = subcategoryRepository.save(new Subcategory(null, "Chocolate", sobremesas));

        // Produtos
        productRepository.save(new Product(
            null,
            "Filé Mignon com Fritas",
            "Filé mignon grelhado com champions, acompanhado de arroz à piamontese e batata frita",
            "https://i.pinimg.com/736x/06/31/bb/0631bb417db2f8a7832689bb6b40346a.jpg",
            350,
            1,
            new BigDecimal("59.90"),
            carnes,
            carnesBovinas
        ));
        productRepository.save(new Product(
                null,
                "Bife à Parmegiana",
                "Bife à Parmegiana, acompanhado de arroz soltinho e batata frita.",
                "https://receitinhas.com.br/wp-content/uploads/2016/12/bife-a-parmegiana-scaled.jpg",
                350,
                1,
                new BigDecimal("35"),
                carnes,
                carnesBovinas
        ));
        productRepository.save(new Product(
                null,
                "Batata frita especial (pequena)",
                "Batata frita com com cheddar e bacon",
                "https://alloydeliveryimages.s3.sa-east-1.amazonaws.com/item_images/6320be279aad9.webp",
                250,
                1,
                new BigDecimal("20"),
                petiscos,
                batataFrita
        ));
        productRepository.save(new Product(
                null,
                "Porção de Pastéis (3 unidades)",
                "Porção com 3 unidades, sendo os sabores de queijo, carne e camarão",
                "https://nutripao.com/wp-content/uploads/2022/08/Pastel-de-Queijo.png",
                null,
                3,
                new BigDecimal("18"),
                petiscos,
                pasteis
        ));
        productRepository.save(new Product(
                null,
                "Lasanha de Frango",
                "Camadas de massa fresca intercaladas com molho de tomate, queijo derretido e pedaços suculentos de frango desfiado.",
                "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2021/08/22/1759609683-lasanha-de-frango-rose-768x512.jpg",
                600,
                2,
                new BigDecimal("44.99"),
                massas,
                lasanhas
        ));
        productRepository.save(new Product(
                null,
                "Spaghetti à Bolonhesa",
                "Spaghetti cozido al dente, coberto com molho de carne moída temperada com ervas e queijo parmesão.",
                "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhWWIRrwqWuyLkh_fd7WGp9ILKMFJNjKTJsG7o4a7vC3hQdLONVpn9j_-sIvy9cSxUxuavDWwg5efGdoAJpxgLWTrigx9pVDq0f4Ge10XDgOW7tHbU_5SgFqky4BXkd2tgsohdUuxYMX_ED_E584hp_y8yOxv-lNw1apfOB9LFaiI0n3EYJg0kp2PTFR2o6/s600/Espaguete%20%C3%A0%20Bolonhesa.jpg",
                600,
                2,
                new BigDecimal("44.99"),
                massas,
                macarrao
        ));
        productRepository.save(new Product(
                null,
                "Arroz Branco",
                "Arroz branco soltinho, temperado com alho e cebola.",
                "https://www.receiteria.com.br/wp-content/uploads/receitas-de-arroz-soltinho.jpg",
                800,
                4,
                new BigDecimal("24.90"),
                guarnicoes,
                arroz
        ));
        productRepository.save(new Product(
                null,
                "Farofa",
                "Farofa tradicional.",
                "https://prontolight.com/wp-content/uploads/2020/08/AV.-11-Thumb.png",
                null,
                null,
                new BigDecimal("7"),
                guarnicoes,
                farofa
        ));
        productRepository.save(new Product(
                null,
                "Feijão Preto",
                "Feijão preto cozido, temperado com alho e coentro.",
                "https://img.freepik.com/fotos-premium/delicioso-prato-da-culinaria-brasileira-chamado-caldo-de-feijao-feito-com-feijao-preto-bacon-e-linguica_261158-2062.jpg",
                500,
                4,
                new BigDecimal("20"),
                guarnicoes,
                arroz
        ));
        productRepository.save(new Product(
                null,
                "Coca Cola (lata)",
                "",
                "https://oportorestaurante.com.br/site2/wp-content/uploads/2021/12/Coca-Cola_Lata_750x600px.png",
                null,
                null,
                new BigDecimal("7"),
                bebidas,
                refrigerantes
        ));
        productRepository.save(new Product(
                null,
                "Coca Cola Zero (lata)",
                "",
                "https://res.cloudinary.com/vuca-solution/image/upload/w_744,h_559,c_fill,q_auto,f_auto/v1648798236/storage.vucasolution.com.br/cabanero/arqs/produtos/h9gkqxmn1ri7xbk6zfrv.jpg",
                null,
                null,
                new BigDecimal("7"),
                bebidas,
                refrigerantes
        ));
        productRepository.save(new Product(
                null,
                "Suco de laranja (copo)",
                "",
                "https://www.citrosuco.com.br/wp-content/uploads/2022/02/THUMB-05.png",
                null,
                null,
                new BigDecimal("10"),
                bebidas,
                refrigerantes
        ));
        productRepository.save(new Product(
                null,
                "Petit Gateu",
                "Bolinho de chocolate macio por fora e recheado com chocolate derretido, servido com uma bola de sorvete de creme",
                "https://pubimg.band.uol.com.br/files/fb5220a7cbd565234274.png",
                null,
                null,
                new BigDecimal("22.99"),
                sobremesas,
                chocolate
        ));

        // Unidades
        unitRepository.save(new Unit(
                null,
                "Barra da Tijuca",
                "(21) 99090-9090",
                new Address("26255-620", "Avenida das Américas", "Barra da Tijuca", "Rio de Janeiro", 4666, "RJ")
        ));
        unitRepository.save(new Unit(
                null,
                "Nova Iguaçu",
                "(21) 99191-9191",
                new Address("22640-102", "Rua Felipe Camarão", "da Luz", "Nova Iguaçu", 1111, "RJ")
        ));
        unitRepository.save(new Unit(
                null,
                "Bela Vista",
                "(11) 99292-9292",
                new Address("01310-100", "Avenida Paulista", "Bela Vista", "São Paulo", 1230, "SP")
        ));
        unitRepository.save(new Unit(
                null,
                "Balneário Camboriú",
                "(47) 99393-9393",
                new Address("88339-005", "Avenida Santa Catarina", "Estados", "Balneário Camboriú", 1, "SC")
        ));

    }
}
