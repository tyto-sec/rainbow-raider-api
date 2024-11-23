# Rainbow Raider API

### **Description**

The **Rainbow Raider API** is a tool designed to facilitate a Rainbow Table attack on hashes such as MD5, SHA-1, SHA-256, and SHA-512 stored in a database. The API provides an endpoint for uploading plaintext password wordlists, converting them into their respective hashes, and storing them in the database.


### **Features**

- **Upload Wordlists**: Upload plaintext passwords and store their corresponding hashes in the database if they are not already present.
- **Search by Hashes**: Retrieve passwords by searching with the following hash types:
    - MD5
    - SHA-1
    - SHA-256
    - SHA-512

### **Technologies Used**

- **Language**: Java 17
- **Framework**: Spring Boot
- **Dependencies**:
    - Spring Web
    - Lombok
    - Password4j
    - Flyway
    - JUnit
- **Database**: PostgreSQL
- **Container Environment**: Docker

### **Prerequisites**

Ensure **Docker** and **Docker Compose** are installed on your system.

### **How to Run the API**

1. Clone the repository:
   ```bash
   git clone https://github.com/tyto-sec/rainbow-raider-api.git
   cd rainbow-raider-api
   ```

2. Configure the database username and password in the `.env` file.

3. Start the Docker environment:

   ```bash
   docker-compose up
   ```

### **Endpoints**

#### **Upload Wordlist**

- **Route**: `POST /api/v1/wordlist`
- **Description**: Upload a plaintext password wordlist.
- **Parameters**:
    - `file`: A `.txt` file containing one password per line.
- **Example (cURL)**:
  ```bash
  curl -X POST -F "file=@wordlist.txt" http://localhost:8080/api/v1/wordlist
  ```

#### **Search by MD5**

- **Route**: `GET /api/v1/md5/{hash}`
- **Description**: Retrieve a password by its MD5 hash.
- **Example (cURL)**:
  ```bash
  curl -X GET http://localhost:8080/api/v1/md5/<md5Hash>
  ```

#### **Search by SHA-1**

- **Route**: `GET /api/v1/sha1/{hash}`
- **Description**: Retrieve a password by its SHA-1 hash.
- **Example (cURL)**:
  ```bash
  curl -X GET http://localhost:8080/api/v1/sha1/<sha1Hash>
  ```

#### **Search by SHA-256**

- **Route**: `GET /api/v1/sha256/{hash}`
- **Description**: Retrieve a password by its SHA-256 hash.
- **Example (cURL)**:
  ```bash
  curl -X GET http://localhost:8080/api/v1/sha256/<sha256Hash>
  ```

#### **Search by SHA-512**

- **Route**: `GET /api/v1/sha512/{hash}`
- **Description**: Retrieve a password by its SHA-512 hash.
- **Example (cURL)**:
  ```bash
  curl -X GET http://localhost:8080/api/v1/sha512/<sha512Hash>
  ```

### **Author**

Developed by **tyto**.