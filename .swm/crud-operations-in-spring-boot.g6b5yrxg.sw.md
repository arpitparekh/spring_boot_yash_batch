---
title: crud operations in spring boot
---
<SwmSnippet path="/src/main/java/com/arpit/spring_boot_yash_batch/controller/ProductController.java" line="29" collapsed>

---

show images

```java
    @GetMapping("/product/image/{id}")
    public ResponseEntity<ByteArrayResource> getProductImage(@PathVariable Long id) {
        Product product = service.getProductById(id);
        if (product.getImage() != null) {
            ByteArrayResource resource = new ByteArrayResource(product.getImage());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image_" + id + ".jpg\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
```

---

</SwmSnippet>

<SwmMeta version="3.0.0" repo-id="Z2l0aHViJTNBJTNBc3ByaW5nX2Jvb3RfeWFzaF9iYXRjaCUzQSUzQWFycGl0cGFyZWto" repo-name="spring_boot_yash_batch"><sup>Powered by [Swimm](https://app.swimm.io/)</sup></SwmMeta>
