Реализация трекера задач

Есть 3 сущности в БД:
Project, TaskStates, Tasks 

Проверка котрольных точек через Postman:

GET http://localhost:8080/api/projects/list
![image](https://github.com/user-attachments/assets/9ca766d9-7c07-4b3b-a9d1-366687864b49)

POST http://localhost:8080/api/projects?name=first-project

![image](https://github.com/user-attachments/assets/c39a36dc-e407-44b4-ad7d-135e75fb0ada)

PATCH  http://localhost:8080/api/projects/1?name=edit-first-project
![image](https://github.com/user-attachments/assets/864377a5-bc5f-488c-8028-9c5f899e9ac9)

GET http://localhost:8080/api/projects/list
![image](https://github.com/user-attachments/assets/88804b94-4f5f-4778-9468-973879e52612)

DELETE http://localhost:8080/api/projects/1
![image](https://github.com/user-attachments/assets/98a6d98d-7f5a-4fab-b6e8-1ec9fcb9cf9b)

GET http://localhost:8080/api/projects/list
![image](https://github.com/user-attachments/assets/c769ea2a-a0fb-400e-b3f6-6fcdc05ba4c0)






