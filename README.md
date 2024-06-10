# Advanced Interoperability Information Systems

This repository contains a project that demonstrates advanced interoperability between a .NET backend and frontend, ActiveMQ for messaging, and jBPM (Camunda) for business process management. It showcases seamless integration and process automation using various technologies.

## Project Overview

- **Backend**: .NET Framework
- **Frontend**: .NET Framework
- **Business Process Management**: jBPM (Camunda)
- **Messaging**: ActiveMQ
- **API Endpoints**: GET, POST, PUT, DELETE
- **Integration**: Mule with Anypoint Studio

### Key Features
1. **.NET Frontend and Backend**: Provides REST API endpoints for GET, POST, PUT, DELETE operations.
2. **Mule Flow Integration**: Consumes REST API endpoints, with requests and responses saved to a textual file.
3. **ActiveMQ Integration**: Saves and receives messages for each request and response.
4. **jBPM Business Process**: Integrated through Java to connect with REST API endpoints for GET, POST, PUT, DELETE.
5. **Service Tasks Integration**: Makes REST API calls to the .NET backend, displays JSON responses in the console, and uses these responses in the process.

### Prerequisites
- .NET Framework
- Java Development Kit (JDK)
- ActiveMQ
- Camunda BPM
- Mule ESB
- Anypoint Studio
