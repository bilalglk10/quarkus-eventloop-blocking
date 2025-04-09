# quarkus-eventloop-blocking

This project is a minimal Quarkus setup to **reproduce and observe blocking behavior** (e.g. `BlockingOperationNotAllowedException`) when using:

- `@RolesAllowed` security
- Inherited REST resource logic (`BaseResource`)
- Mutiny's `Uni` reactive API

## How to build
```sh
./mvnw clean package quarkus:dev
```

## Test
```sh
curl -u alice:alice \
  -X POST http://localhost:8081/reproducer \
  -H "Content-Type: text/plain" \
  -d 'hello'
```