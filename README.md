# RSManager

frontend/
├── public/
│   └── index.html
├── src/
│   ├── main.js
│   ├── App.vue
│   ├── router/
│   │   └── index.js
│   ├── store/
│   │   └── index.js
│   ├── views/
│   │   ├── Dashboard.vue
│   │   ├── Login.vue
│   │   ├── UserManagement.vue
│   │   ├── GroupManagement.vue
│   │   ├── AgentManagement.vue
│   │   ├── Reports.vue
│   │   └── Settings.vue
│   ├── components/
│   │   ├── Header.vue
│   │   ├── Sidebar.vue
│   │   └── Breadcrumb.vue
│   ├── assets/
│   │   ├── styles/
│   │   │   └── main.css
│   │   └── images/
│   ├── utils/
│   │   ├── request.js
│   │   ├── auth.js
│   │   └── permissions.js
│   ├── permission.js
│   └── api/
│       └── index.js
├── .env.development
├── .env.production
├── package.json
└── vue.config.js


backend/
└──src
    └── main
        ├── java
        │   └── com
        │       └── rsmanager
        │           ├── model
        │           │   ├── BackendUser.java
        │           │   └── BackendRole.java
        │           ├── repository
        │           │   └── local
        │           │       ├── BackendUserRepository.java
        │           │       └── BackendRoleRepository.java
        │           ├── security
        │           │   ├── CustomUserDetails.java
        │           │   ├── CustomUserDetailsService.java
        │           │   ├── JwtAuthenticationEntryPoint.java
        │           │   ├── JwtAuthenticationFilter.java
        │           │   └── JwtTokenUtil.java
        │           ├── config
        │           │   └── SecurityConfig.java
        │           └── controller
        │               └── AuthController.java
        └── resources
            └── application.properties