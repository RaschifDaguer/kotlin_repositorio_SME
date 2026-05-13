# kotlin_repositorio_SME

## Descripción
Proyecto APK educativo para aprender programación en Kotlin. Aplicación móvil que proporciona tutoriales y ejercicios interactivos sobre conceptos fundamentales de Kotlin.

## Progreso del Proyecto

### ✅ Fase 1: Estructura Base Completada
- [x] Configuración inicial del proyecto Android
- [x] Creación de Activity principal (HomeActivity)
- [x] Estructura de carpetas de recursos

### 🔄 Fase 2: Interfaz de Usuario (En Desarrollo)
- [x] Diseño de HomeActivity con ConstraintLayout
- [x] Header personalizado con color púrpura
- [x] Mensaje de bienvenida dinámico con nombre de usuario
- [x] Implementación de RecyclerView para lista de tutoriales
- [x] Creación de TutorialAdapter para mostrar elementos
- [x] Integración de MaterialCardView para diseño moderno

### 📋 Tutoriales Incluidos
1. Variables y Tipos - Diferencia entre 'val' (inmutable) y 'var' (mutable)
2. Funciones Compactas - Aprende a escribir funciones en una sola línea
3. Estructura 'When' - La versión potente y moderna del switch de Java
4. Null Safety - Evita el famoso NullPointerException con '?'
5. Listas y Colecciones - Manejo eficiente de datos
6. Corrutinas - Introducción a la programación asíncrona
7. Extension Functions - Añade funcionalidad a clases existentes

### 🚀 Próximas Fases Planificadas
- [ ] Implementación de pantalla detallada de tutoriales
- [ ] Sistema de evaluación y cuestionarios
- [ ] Base de datos local para guardar progreso
- [ ] Navegación entre actividades
- [ ] Sistema de puntuación y logros

## Cambios Agregados en esta Actualización (13/05/2026)
- **HomeActivity.kt**: Mejorada la funcionalidad con RecyclerView dinámico y manejo de usuario
- **activity_home.xml**: Layout actualizado con diseño mejorado y componentes Material Design
- **README.md**: Documentación completa del proyecto y estado de progreso

## Estructura del Proyecto
```
first_apk/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/firstapk/
│   │   │   │   ├── HomeActivity.kt
│   │   │   │   ├── TutorialAdapter.kt
│   │   │   │   └── TutorialItem.kt
│   │   │   └── res/
│   │   │       └── layout/
│   │   │           └── activity_home.xml
│   │   ├── test/
│   │   └── androidTest/
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## Requisitos
- Android SDK 34+
- Kotlin 1.9+
- Gradle 8.0+

## Cómo Ejecutar
1. Clonar el repositorio
2. Abrir en Android Studio
3. Sincronizar Gradle
4. Ejecutar en un emulador o dispositivo físico