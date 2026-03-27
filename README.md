# Secure Mobile Banking & Instant Transaction Monitoring System

A comprehensive, secure mobile banking application with real-time transaction monitoring and fraud detection capabilities.

## 🚀 Features

### Core Banking Features
- **User Registration & Authentication** - Secure JWT-based authentication with BCrypt password hashing
- **Account Management** - Multiple account types with balance tracking and currency support
- **Fund Transfers** - Real-time money transfers between accounts with OTP verification
- **Transaction History** - Complete transaction tracking with detailed records
- **Profile Management** - User profile updates and account settings

### Security & Monitoring
- **Real-time Transaction Monitoring** - Instant detection of suspicious activities
- **Fraud Detection** - AI-powered alert system for unusual transaction patterns
- **Account Lockout Protection** - Automatic account locking after failed login attempts
- **OTP Verification** - Two-factor authentication for sensitive operations
- **Audit Logging** - Comprehensive security audit trails

### Admin Features
- **Admin Dashboard** - Complete system oversight and user management
- **Alert Management** - Review and resolve security alerts
- **User Management** - Admin controls for user accounts and permissions
- **Transaction Monitoring** - Real-time transaction oversight

## 🛠 Tech Stack

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.2.0
- **Language**: Java 17
- **Security**: Spring Security, JWT, BCrypt
- **Database**: MySQL with JPA/Hibernate
- **Validation**: Jakarta Bean Validation
- **Build Tool**: Maven

### Frontend (React)
- **Framework**: React 18
- **UI Library**: Material-UI (MUI)
- **Routing**: React Router DOM v6
- **HTTP Client**: Axios
- **State Management**: React Context API
- **Form Management**: React Hook Form

### Database
- **Primary**: MySQL 8.0
- **ORM**: Spring Data JPA
- **Migrations**: SQL schema scripts

## 📁 Project Structure

```
Secure Mobile Banking/
├── backend/                    # Spring Boot Backend
│   ├── src/main/java/com/banking/
│   │   ├── controller/         # REST API Controllers
│   │   ├── service/           # Business Logic Services
│   │   ├── repository/        # Database Repositories
│   │   ├── entity/           # JPA Entities
│   │   ├── dto/              # Data Transfer Objects
│   │   ├── security/         # Security Configuration
│   │   └── config/           # Application Configuration
│   └── src/main/resources/
│       ├── application.properties  # Application Configuration
│       └── schema.sql             # Database Schema
├── frontend/                   # React Frontend
│   ├── src/
│   │   ├── components/        # Reusable Components
│   │   ├── pages/            # Page Components
│   │   ├── contexts/         # Context Providers
│   │   ├── services/         # API Service Calls
│   │   ├── utils/            # Utility Functions
│   │   └── styles/           # CSS/SCSS Files
│   └── public/               # Static Assets
├── database/                  # Database Scripts
└── documentation/            # Project Documentation
```

## 🔧 Installation & Setup

### Prerequisites
- Java 17+
- Maven 3.6+
- Node.js 16+
- MySQL 8.0+
- npm or yarn

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Secure-Mobile-Banking/backend
   ```

2. **Configure database**
   - Update `application.properties` with your MySQL credentials
   - Run `database/schema.sql` to create the database schema

3. **Build and run**
   ```bash
   mvn clean compile
   mvn spring-boot:run
   ```

4. **Backend will be available at**: `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd ../frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   # or
   yarn install
   ```

3. **Start development server**
   ```bash
   npm start
   # or
   yarn start
   ```

4. **Frontend will be available at**: `http://localhost:3000`

## 🏗 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `GET /api/auth/me` - Get current user

### Users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Accounts
- `GET /api/accounts` - Get user accounts
- `GET /api/accounts/{id}` - Get account by ID
- `POST /api/accounts/transfer` - Transfer funds

### Transactions
- `GET /api/transactions` - Get user transactions
- `GET /api/transactions/{id}` - Get transaction by ID

### Alerts
- `GET /api/alerts` - Get user alerts
- `PUT /api/alerts/{id}/resolve` - Resolve alert

## 🔒 Security Features

### Authentication & Authorization
- JWT tokens with configurable expiration
- Role-based access control (USER, ADMIN)
- Password encryption with BCrypt
- Account lockout after failed attempts

### Transaction Security
- OTP verification for transfers
- Real-time fraud detection
- Transaction limits and monitoring
- Audit logging for all operations

### Data Protection
- Input validation and sanitization
- SQL injection prevention
- XSS protection
- Secure session management

## 📊 Database Schema

The system uses a relational database with the following key entities:

- **Users**: User accounts with authentication data
- **Accounts**: Bank accounts linked to users
- **Transactions**: Financial transactions between accounts
- **Alerts**: Security alerts for suspicious activities
- **OtpTokens**: One-time passwords for verification
- **AuditLogs**: Security audit trails

## 🚀 Deployment

### Docker (Recommended)
```bash
# Build and run with Docker Compose
docker-compose up --build
```

### Production Deployment
1. Build production artifacts
2. Configure production environment variables
3. Deploy to cloud platform (AWS, Azure, GCP)
4. Set up SSL/TLS certificates
5. Configure monitoring and logging

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
# or
yarn test
```

## 📈 Monitoring & Analytics

- **Real-time Transaction Monitoring**
- **Fraud Detection Metrics**
- **User Activity Analytics**
- **System Performance Monitoring**
- **Security Alert Dashboard**

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for your changes
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation

## 🔗 Related Projects

- [Banking API Documentation](docs/api.md)
- [Security Guidelines](docs/security.md)
- [Deployment Guide](docs/deployment.md)

---
