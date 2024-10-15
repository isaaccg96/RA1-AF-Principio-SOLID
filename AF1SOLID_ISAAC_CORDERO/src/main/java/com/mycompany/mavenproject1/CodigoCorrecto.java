/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Isaac Cordero García
 */
public class CodigoCorrecto {
    //1. Corrección del SRP:
    public static class Report {
        //Atributos:
        private String title;
        private String body;
        //Constructor:
        public Report(String title, String body) {
            this.title = title;
            this.body = body;
        }
        //Métodos:
        public String getTitle() {
            return title;
        }
        public String getBody() {
            return body;
        }
    }
    
    public static class ReportGenerator {
        //Métodos:
        public void generateReport(Report report) {
            // Genera el reporte en un formato específico
            System.out.println("Generating report: " + report.getTitle());
        }
    }
    
    public static class ReportPrinter {
        //Métodos:
        public void printReport(Report report) {
            // Imprime el reporte
            System.out.println("Printing report: " + report.getTitle());
        }
    }
    
    //2. Corrección de OCP
    // Interfaz para el dibujo de formas
    public interface Drawable {
        void draw();
    }
    // Implementación de un círculo
    public static class Circle implements Drawable {
        @Override
        public void draw() {
            System.out.println("Drawing a circle");
        }
    }
    // Implementación de un cuadrado
    public static class Square implements Drawable {
        @Override
        public void draw() {
            System.out.println("Drawing a square");
        }
    }
    // Clase de cliente que usa Drawable
    public static class ShapeDrawer {
        private Drawable shape;
        
        public ShapeDrawer(Drawable shape) {
            this.shape = shape;
        }
        public void drawShape() {
            shape.draw();
        }
    }
    //Ejemplo con un producto:
    //Codigo Incumplimiento:
    public static class Producto {
        private String nombre;
        private double precioBase;
        public Producto(String nombre, double precioBase) {
            this.nombre = nombre;
            this.precioBase = precioBase;
        }
        public double calcularPrecio() {
            return precioBase;
        }
        public String getNombre() {
            return nombre;
        }
        public double getPrecioBase() {
            return precioBase ;
        }
    }
    
    // Producto con descuento
    public static class ProductoConDescuento extends Producto {
        private double porcentajeDescuento;
        public ProductoConDescuento(String nombre, double precioBase, double
        porcentajeDescuento) {
            super(nombre, precioBase);
            this.porcentajeDescuento = porcentajeDescuento;
        }
        @Override
        public double calcularPrecio() {
            return getPrecioBase() - (getPrecioBase() * (porcentajeDescuento / 100));
        }
    }
    
    // Producto con impuesto
    public static class ProductoConImpuesto extends Producto {
        private double porcentajeImpuesto;
        public ProductoConImpuesto(String nombre, double precioBase, double
        porcentajeImpuesto) {
            super(nombre, precioBase);
            this.porcentajeImpuesto = porcentajeImpuesto;
        }
        @Override
        public double calcularPrecio() {
            return getPrecioBase() + (getPrecioBase() * (porcentajeImpuesto / 100));
        }
    }
    
    //3.Corrección de ISP:
    public interface Workable {
        void work();
    }
    public interface Eatable {
        void eat();
    }
    public static class HumanWorker implements Workable, Eatable {
        @Override
        public void work() {
            System.out.println("Working...");
        }
        @Override
        public void eat() {
            System.out.println("Eating...");
            }
    }
    public static class RobotWorker implements Workable {
        @Override
        public void work() {
            System.out.println("Working...");
        }
    }
    
    //4.Corrección de LSP
    // Nueva interfaz para voladores
    public interface Volador {
        void volar();
    }
    // Clase Ave sin el método volar
    public static class Ave {
        private String nombre;
        public Ave(String nombre) {
        this.nombre = nombre;
        }
        public String getNombre() {
            return nombre;
        }
    }
    // Clase Avestruz, que no implementa Volador porque no vuela
    public static class Avestruz extends Ave {
        public Avestruz(String nombre) {
            super(nombre);
        }
    }
    // Clase Gorrion, que sí puede volar
    public static class Gorrion extends Ave implements Volador {
        public Gorrion(String nombre) {
            super(nombre);
        }
        @Override
        public void volar() {
            System.out.println("El gorrión está volando");
        }
    }
    
     //5.Corrección de DIP:
    // Interfaz que define el comportamiento de cualquier dispositivo que se pueda encender o apagar
    public interface Encendible {
        void encender();
        void apagar();
    }
    // Implementación de la interfaz Encendible para una bombilla
    public static class Bombilla implements Encendible {
        @Override
        public void encender() {
            System.out.println("La bombilla está encendida");
        }
        @Override
        public void apagar() {
            System.out.println("La bombilla está apagada");
        }
    }
    // Clase Interruptor que ahora depende de la abstracción (cumple con el DIP)
    public static class Interruptor {
        private Encendible dispositivo;
        public Interruptor(Encendible dispositivo) {
            this.dispositivo = dispositivo;
        }
        public void operar() {
            dispositivo.encender();
            // Más tarde: dispositivo.apagar();
        }
    }
    
   //Ejecución de las clases para comprobar la lógica y funcionamiento:
    public static void main(String[] args) {
        //Entorno:
        Report report;
        ReportGenerator reportGenerator;
        ReportPrinter reportPrinter;
        
        Circle circle;
        Square square;
        ShapeDrawer shapeDrawer,shapeDrawer2;
        
        HumanWorker humanWorker;
        RobotWorker robotWorker;
        
        Avestruz avestruz;
        Gorrion gorrion;
        
        Bombilla bombilla;
        Interruptor interruptorBombilla;
        
        //Algoritmo:
        report = new Report("Titulo","Cuerpo");
        reportGenerator = new ReportGenerator();   
        reportGenerator.generateReport(report);
        reportPrinter = new ReportPrinter();
        reportPrinter.printReport(report);
        
        circle = new Circle();
        square = new Square();
        shapeDrawer = new ShapeDrawer(circle);
        shapeDrawer2 = new ShapeDrawer(square);
        shapeDrawer.drawShape();
        shapeDrawer2.drawShape();
        
        Producto producto = new Producto("Laptop", 1000);
        ProductoConDescuento productoConDescuento = new
        ProductoConDescuento("Smartphone", 500, 10);
        ProductoConImpuesto productoConImpuesto = new ProductoConImpuesto("Tablet",
        300, 21);
        System.out.println("Precio del producto: " + producto.getNombre() + " es: " +
        producto.calcularPrecio());
        System.out.println("Precio del producto con descuento: " +
        productoConDescuento.getNombre() + " es: " + productoConDescuento.calcularPrecio());
        System.out.println("Precio del producto con impuesto: " +
        productoConImpuesto.getNombre() + " es: " + productoConImpuesto.calcularPrecio());
        
        humanWorker = new HumanWorker();
        robotWorker = new RobotWorker();
        humanWorker.eat();
        humanWorker.work();
        robotWorker.work();
        //robotWorker.eat(); Aquí no se usa puesto que no implementa la interfaz ineficientemente
        
        avestruz = new Avestruz("Pepe");
        gorrion = new Gorrion("Lola");
        System.out.println(avestruz.getNombre());
        System.out.println(gorrion.getNombre());
        gorrion.volar();
        //El avestruz no posee el método de volar porque no implementa la interfaz volador
        
        bombilla = new Bombilla();
        interruptorBombilla = new Interruptor(bombilla);
        bombilla.encender();
        bombilla.apagar();
        interruptorBombilla.operar();
    }       
}
