# Cotton Factory Developer Docs

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
    public List<String> getShirts() {
        return new ArrayList<>();
    }
}
```