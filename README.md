# Hospital Patient App
**Project Description: Patient Hospital Records App**

**Overview:**
The Patient Hospital Records App is a comprehensive software solution designed to manage patient records within hospital systems efficiently. It offers functionalities to store, retrieve, update, and analyze patient data securely. The application is built with versatility in mind, utilizing MySQL database for production environments and H2 database for testing purposes. It seamlessly integrates with Artemis MQ 5 for reliable messaging across the system.

**Key Features:**

1. **Patient Record Management:** The app allows healthcare providers to create, view, update, and delete patient records securely. It stores essential information such as patient demographics, medical history, treatments, and diagnostic reports.
  
2. **Integration with Artemis MQ 5:** Messaging functionality is seamlessly integrated using Artemis MQ 5, ensuring reliable communication between different components of the system. This facilitates real-time updates and notifications, enhancing overall system responsiveness.

3. **Environment Profiles and Properties:** The application supports multiple environment profiles to cater to different deployment scenarios. Configuration properties are managed dynamically, allowing seamless transitions between development, testing, and production environments. MySQL database is utilized for production deployments, while H2 database is employed for testing purposes, ensuring data isolation and integrity.


**Technology Stack:**
- **Backend:** Java Spring Boot
- **Database:** MySQL (Production), H2 (Testing)
- **Messaging:** Artemis MQ 5
