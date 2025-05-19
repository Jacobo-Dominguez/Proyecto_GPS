# 🚌 Sistema de Simulación GPS para Autobuses (TUSSAM)

Proyecto Java de consola que simula el seguimiento de autobuses urbanos mediante datos GPS. El sistema cubre todo el ciclo de vida del dato: desde la generación hasta el archivado, pasando por el análisis, visualización y exportación.

---

## 🎯 Objetivo

Simular el monitoreo de rutas de autobuses (BUS27, BUS22, BUS29) utilizando datos GPS realistas generados automáticamente, para luego almacenarlos, analizarlos y visualizarlos.

---

## 🗂️ Estructura del Proyecto

```plaintext
Proyecto_GPS/
├── archivados/         # Archivos CSV antiguos (automáticamente archivados o eliminados si >7 días)
├── doc/                # Documentación del proyecto (PDF con enunciado)
├── src/
│   ├── clases/         # Clases con lógica del proyecto (análisis, filtrado, visualización, etc.)
│   │   ├── GPSAnalisis.java
│   │   ├── GPSCargar.java
│   │   ├── GPSData.java
│   │   ├── GPSEliminar.java
│   │   ├── GPSFiltrar.java
│   │   ├── GPSModificar.java
│   │   ├── GPSValidar.java
│   │   ├── GPSVisualizar.java
│   │   └── MenuInteractivo
│   ├── ejecuciones/    # Clases para ejecutar cada punto del ejercicio por separado
│   │   ├── MainAnalisis.java
│   │   ├── MainData.java
│   │   ├── MainEliminar.java
│   │   ├── MainExportar.java
│   │   ├── MainFiltro.java
│   │   ├── MainMenu.java
│   │   ├── MainModificar.java
│   │   └── MainVisualizar
│   │
│   ├── GPSSimulator22.java   # Simulador para la línea 22
│   ├── GPSSimulator27.java   # Simulador para la línea 27
│   ├── GPSSimulator29.java   # Simulador para la línea 29
│   ├── Paradas               # Clase con los atributos de las paradas
│   └── AppBuses.java         # Menú interactivo principal (punto de entrada del proyecto)

---

## 🚏 Rutas Simuladas

Se simulan tres líneas reales de TUSSAM:

- **BUS27**: Plaza de Armas ↔ Polígono San Pablo
- **BUS22**: Plaza de la Gavidia ↔ Polígono San Pablo
- **BUS29**: Plaza de Armas ↔ Bermejales

Cada ruta incluye coordenadas GPS reales aproximadas de las paradas.

---

## 🔁 Funcionalidades

### Menu General
Se ha creado un menu general `AppBuses` (distinto del menu opcional) 
que lo que hace es juntar todos los puntos que se detallan a 
continuacion en un solo menu. 

### ✅ Captura / Generación
- Datos simulados cada minuto por 60 minutos.
- Atributos: `busId`, `timestamp`, `latitude`, `longitude`, `speed`.
- Generación automática con `GPSSimulatorXX.java`.

### ✅ Almacenamiento
- Datos guardados como `gps_data_busXX.csv`.
- También almacenados en `ArrayList<GPSData>`.

### ✅ Procesamiento
- Validación de coordenadas, velocidad y formato de fecha.
- Filtro por autobús o rango horario.

### ✅ Análisis
- Cálculo de velocidad media.
- Conteo de paradas por ruta.

### ✅ Exportación
- Última posición exportada como JSON:  
  Ejemplo:
  ```json
  {
    "busId": "BUS27",
    "latitude": 37.39762,
    "longitude": -5.98246,
    "timestamp": "2025-05-08T08:45:00"
  }

### ✅ Visualización
Trayecto completo mostrado por consola.

Menú interactivo opcional (consultar estado de un bus).

### ✅ Archivado / Limpieza
Archiva automáticamente los CSV en /archivados/.

Elimina los que tienen más de 7 días, según su timestamp.