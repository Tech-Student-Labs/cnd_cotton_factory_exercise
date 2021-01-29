# Cotton Factory Developer Docs

![Service Status](https://github.com/Tech-Student-Labs/cnd_cotton_factory_exercise/workflows/Deploy%20to%20Heroku/badge.svg)

You can visit the Swagger docs for this API at [https://cotton-factory-1220.herokuapp.com/swagger-ui.html](https://cotton-factory-1220.herokuapp.com/swagger-ui.html)
## Documenting Your Code

- Every controller must be annotated with `@Api("some short description")` imported from `import io.swagger.annotations.Api`

Once annotated, that's all. Your features will appear in the Swagger docs.

```java
import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/v1/products/clothes")
@Api(tags = {"clothes"})
public class ClothesApiController {

    @GetMapping
    public List<String> getAllClothes() {
        return new ArrayList<>();
    }
}
```

## Teams

| Team | Members                                                                                                        | Products             |
|------|----------------------------------------------------------------------------------------------------------------|----------------------|
| 1    | Hemasree Darisiguntla & Anurag Vishnoi & Xiaonan Wei & Peter Trotter                                           | Pants and Slacks     |
| 2    | Parthiban Samykutti & Jose Durazo & Shashi Kumar R & Subhrajit Banerjee & Asiyat Kush                          | Skirts and Dresses   |
| 3    | Gokula Krishnan Thiruppathi Venkatesan & Srijan Khan & Amalesan Subramanian & Jennifer Dalton                  | Shirts and Sweaters  |
| 4    | Prasanth Sivakoti & Bharathi Mohan Bhagyanath & Uthiraraj Saminathan & RamaKrishnan Ramasamy & Ofeoritse Nanna | Ties and Accessories |
| 5    | Naga Vijaya Patibandla & Bala Balaji Achanta & Nagarjuna Boddu & Vyom Rastogi                                  | Jackets and Shoes    |

## Github Actions

- [Environment Variables](https://docs.github.com/en/actions/reference/environment-variables)


