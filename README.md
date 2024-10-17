# Sales ERP Product

This Spring Boot application facilitates the management of product sales, offering a RESTful API for CRUD operations and advanced data insights. Utilizing JPA Streamer, it efficiently retrieves and processes product information.

## Features
- Manage products (Create, Read, Update, Delete)
- Group products by supplier and category
- Identify expired products
- Analyze best-selling products and calculate profits
- Track remaining stock levels

## Getting Started
1. Clone the repository: `git clone https://github.com/MuhammedBasith/sales-erp-product.git`
2. Navigate to the project directory: `cd sales-erp-product`
3. Build the project: `./mvnw clean install`
4. Run the application: `./mvnw spring-boot:run`

## API Endpoints
- `GET /api/products` - Retrieve all products
- `POST /api/products` - Add a new product
- `GET /api/products/{id}` - Get product by ID
- `DELETE /api/products/{id}` - Delete product by ID
- `GET /api/products/suppliers` - Get products grouped by supplier
- `GET /api/products/category` - Get products grouped by category
- `GET /api/products/expired` - Find expired products
- `GET /api/products/bestseller` - Best-selling products by category
- `GET /api/products/profit` - Calculate profits for products
- `GET /api/products/availablestock` - Calculate remaining stock

## Contributing
Contributions are welcome! Please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.
