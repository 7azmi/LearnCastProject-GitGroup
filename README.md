# Lab Activity Week 6(b) - Group Work (5%) …...Cont…...
## Development of BMI and Fitness Web App using Spring Web MVC

### Task 6(b): Implementing Client and Admin Modules - Controller Logic and Views with Server-Side View Rendering

---

### Objective

By the end of this lab activity, you will:

1. Develop and complete the `ClientController` and `AdminController` classes to handle data fetching, input validation, data storage, and preparation of ViewModel data for rendering in JSP views.
2. Use static lists to simulate a database, storing form data for both Client and Admin modules.
3. Create ViewModel classes to structure data for JSP views.
4. Design and complete JSP pages for the Client and Admin modules, integrating dynamic data from the ViewModel.

---

### Description

In this lab, you will expand on your work from Week 5(b) by building out core functionality for the Client and Admin modules. You will finalize the controller methods for these two modules, simulate database interactions using static lists, and build corresponding JSP views for server-side HTML rendering. 

You need to handle form data submission, validate inputs, store records in memory, and prepare data for dynamic rendering in JSP pages using ViewModel classes.

---

### Instructions

#### 1. Setup:
- Ensure the project structure includes the required directories for controllers, models, services, and views.
- Set up the initial `ClientController` and `AdminController` classes if not already done.

#### 2. Task 1: Implement `ClientController`

**Objectives:**
- Capture form data for client registration and profile management.
- Validate inputs (e.g., name, email, password strength (optional), and BMI-related fields).
- Save validated data to a static list (e.g., `List<Client>`).

**Steps:**
- Define methods in `ClientController`:
    - `showRegisterForm()` - Displays the registration page (`register.jsp`).
    - `showLoginForm()` - Displays the login page (`login.jsp`).
    - `processRegisterForm()` - Handles form submission for client registration.
    - `showProfile()` - Displays the client profile page (`profile.jsp`).

**Implementation:**
- In `showRegisterForm()`, forward the user to `register.jsp`.
- In `showLoginForm()`, forward the user to `login.jsp`.
- In `processRegisterForm()`, capture form data, validate inputs, and store client data in a static list if validation passes. If validation fails, display error messages on `register.jsp`.
- In `processLoginForm()`, validate user credentials using the static list of registered clients. If valid, redirect to `profile.jsp`; otherwise, display an error on `login.jsp`.
- In `showProfile()`, retrieve the client’s data from the static list and forward it to `profile.jsp`.

**JSP Integration:**
- Use `model.addAttribute()` in each method to pass data to the JSP pages for display.

#### 3. Task 2: Implement `AdminController`

**Objectives:**
- Manage client data, roles, and programs using server-rendered JSP views.
- Implement CRUD operations for managing clients and fitness programs.

**Steps:**
- Define methods in `AdminController`:
    - `showClientList()` - Displays a list of all registered clients (`clientList.jsp`).
    - `showAddProgramForm()` - Displays a form to add a new fitness program (`addProgram.jsp`).
    - `processAddProgramForm()` - Handles form submission for new programs.
    - `showManageRoles()` - Displays a page for managing client roles (`manageRoles.jsp`).

**Implementation:**
- In `showClientList()`, retrieve the list of clients from the static list and forward it to `clientList.jsp`.
- In `showAddProgramForm()`, forward directly to `addProgram.jsp`.
- In `processAddProgramForm()`, handle form data to add a new fitness program, validate inputs, and store the program in a static list if validation is successful.
- In `showManageRoles()`, forward necessary data to `manageRoles.jsp` for assigning roles.

**JSP Integration:**
- Use `model.addAttribute()` to bind data for JSP views such as lists of clients and program details.

#### 4. Task 3: Create ViewModel Classes

**Objectives:**
- Use ViewModel classes to organize data for JSP views.
- Keep business logic separate from presentation.

**Steps:**
- Create a `ClientViewModel` class to format data for `profile.jsp` and `clientList.jsp`.
- Create an `AdminViewModel` class to format data for `addProgram.jsp` and `manageRoles.jsp`.
- Populate the ViewModel classes with data retrieved from static lists.

#### 5. Task 4: Design and Complete JSP Views

**Objectives:** Develop dynamic JSP pages that render data passed from controllers for Client and Admin modules.

**Steps:**

**For Client:**
- `register.jsp`: Form for new clients to sign up with fields for name, email, password, and any other relevant details.
- `login.jsp`: Create a login form for clients with fields for email and password. Include input validation and display error messages for incorrect credentials.
- `profile.jsp`: Displays client details and includes editable fields for updating profile information.

**For Admin:**
- `clientList.jsp`: Displays a list of all registered clients, with options to view and manage each client.
- `addProgram.jsp`: Form to add new fitness programs, including fields like program name, description, and duration.
- `manageRoles.jsp`: Interface to assign roles to clients, displaying a list of users and available roles.

Use JSTL tags (`<c:forEach>`, `<c:if>`) to loop through lists and handle conditional rendering in the JSP files.

#### 6. Testing

- Test each JSP view to ensure dynamic content renders correctly from ViewModel classes.
- Test form submissions to verify data is validated and stored correctly.
- Verify role-based access by ensuring that Admin-specific pages (e.g., `clientList.jsp` and `manageRoles.jsp`) are accessible only to Admin users.

---

### Deliverables

1. **Controllers:**
   - Fully implemented controller classes for the modules, including `ClientController`, `AdminController`.
   - Each controller should handle data fetching, validation, storage, and forwarding data to JSP views using ViewModel classes.

2. **ViewModel Classes:**
   - Complete ViewModel classes for each module, including `ClientViewModel`, `AdminViewModel`.
   - Each ViewModel class should prepare data in a structured format for JSP views, simplifying data access and presentation.

3. **JSP Views:**
   - Complete JSP pages for all modules, implementing dynamic data rendering and form handling for each module’s specific tasks.
     - **Client Module:** `register.jsp`, `login.jsp`, `profile.jsp`
     - **Admin Module:** `clientList.jsp`, `addProgram.jsp`, `manageRoles.jsp`

Each JSP view should be set up to display data dynamically from the corresponding ViewModel class and support form submissions, where applicable. This structure provides a comprehensive framework for delivering a fully functional web application with each module implemented according to MVC principles, using Spring Web MVC and JSP for server-side rendering.

---

### Documentation:
- A brief report describing each controller method, data flow, validation rules, and any issues encountered.

---

### Assessment Criteria

- **Correct Implementation:** All controllers and JSP views function as expected. [Only `ClientController` and `AdminController`]
- **Input Validation:** Appropriate validation is applied, with errors displayed on invalid input.
- **Data Storage:** Static lists correctly simulate a database.
- **Code Structure:** MVC structure is followed with ViewModels effectively used.
- **Documentation:** Clear descriptions and explanations are provided.

This lab reinforces your understanding of MVC architecture and gives you practical experience with JSP and server-side rendering in Java Web applications.
