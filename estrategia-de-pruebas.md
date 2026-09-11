# Estrategia de pruebas — Instagram

Documento de priorización de los primeros 10 casos a automatizar, aplicando el criterio de la pirámide de tests y el ROI (impacto vs. costo de mantenimiento).

| # | Caso | Nivel de test | Por qué |
|---|------|----------------|---------|
| 1 | Iniciar sesión con credenciales válidas | E2E (UI) | Es la puerta de entrada a toda la app. Ojo: dependiente de la red, riesgo de flaky. |
| 2 | Las historias cargan correctamente | E2E (UI) | Feature usada constantemente por millones de usuarios; alto impacto si falla. |
| 3 | El link de una publicidad redirige a la página correcta | API + E2E | La URL se puede validar rápido por API; el click real se complementa con un test E2E. Impacto económico directo (el anunciante paga por esto). |
| 4 | Publicar una foto/video | E2E (UI) | Crítico para cuentas comerciantes: es su forma de vender. |
| 5 | Enviar un mensaje directo sin demoras | API (funcional) + test de performance aparte | El envío se valida rápido por API; la demora se mide con un test de tiempos, no con UI. |
| 6 | Dar like y que se refleje visualmente | API (guardado del dato) + E2E (ícono en pantalla) | Dos capas: el dato se guarda en el backend, y el usuario necesita ver el cambio reflejado. |
| 7 | Comentar en una publicación | API + E2E | Igual que el like: se guarda (API) y se muestra (UI). |
| 8 | Buscar un perfil de usuario | E2E (UI) | Flujo de descubrimiento, usado todo el tiempo. |
| 9 | Seguir / dejar de seguir una cuenta | API + E2E | Cambio de estado validable rápido por API, con verificación visual complementaria. |
| 10 | Eliminar una publicación propia | E2E (UI) | Poco frecuente pero alto impacto de negocio si falla (contenido sensible o de venta que queda visible por error). |