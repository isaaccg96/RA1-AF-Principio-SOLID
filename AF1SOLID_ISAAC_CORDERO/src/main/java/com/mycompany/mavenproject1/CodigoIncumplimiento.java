/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Isaac Cordero García
 */
public class CodigoIncumplimiento {
    //1. Incumplimiento del SRP
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
        public void generateReport() {
            // Genera el reporte en un formato específico
            System.out.println("Generating report...");
        }
        public void printReport() {
            // Imprime el reporte
            System.out.println("Printing report: " + title);
        }
    }
    
    //2. Incumplimiento del OCP
    public static class Shape {
        //Atributos:
        public static final int CIRCLE = 1;
        public static final int SQUARE = 2;
        private int shapeType;
        //Constructor:
        public Shape(int shapeType) {
            this.shapeType = shapeType;
        }
        //Métodos:
        public void draw() {
            if (shapeType == CIRCLE) {
                drawCircle();
            } else if (shapeType == SQUARE) {
                drawSquare();
            }
        }
        private void drawCircle() {
            System.out.println("Drawing a circle");
        }
        private void drawSquare() {
            System.out.println("Drawing a square");
        }
    }
    //Ejemplo con un producto:
    public class Producto {
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
    
    //3.Incumplimiento del ISP:
    public interface Worker {
        void work();
        void eat();
    }
    public static class HumanWorker implements Worker {
        @Override
        public void work() {
            System.out.println("Working...");
        }             
        @Override
        public void eat() {
            System.out.println("Eating...");
        }
    }
    public static class RobotWorker implements Worker {
        @Override
        public void work() {
            System.out.println("Working...");
        }
        @Override
        public void eat() {
            throw new UnsupportedOperationException("Robots don't eat");
        }
    }
    
    //4.Incumplimiento del LSP:
    public static class Ave {
        public void volar() {
            System.out.println("El ave está volando");
        }
    }
    public static class Avestruz extends Ave {
        @Override
        public void volar() {
            throw new UnsupportedOperationException("Las avestruces no pueden volar");
        }
    }
        
    //5.Incumplimiento del DIP:
    // Clase que representa una bombilla
    public static class Bombilla {
        public void encender() {
            System.out.println("La bombilla está encendida");
        }
        public void apagar() {
            System.out.println("La bombilla está apagada");
        }
    }
    // Clase Interruptor que depende de Bombilla (violación del DIP)
    public static class Interruptor {
        private Bombilla bombilla;
        public Interruptor(Bombilla bombilla) {
            this.bombilla = bombilla;
        }
        public void operar() {
            bombilla.encender();
            // Más tarde: bombilla.apagar();
        }
    }
                            
    //Ejecución de las clases para comprobar la lógica y funcionamiento:       
    public static void main(String[] args) {
        //Entorno:
        Report prueba;
        Shape shape;
        HumanWorker humanWorker;
        RobotWorker robotWorker;
        Avestruz avestruz;
        Bombilla bombilla;
        Interruptor interruptorBombilla;
        
        //Algoritmo:
        prueba = new Report("Titulo", "Cuerpo");
        prueba.generateReport();
        prueba.printReport();
        
        shape = new Shape(1);
        shape.draw();
        shape.drawCircle();
        shape.drawSquare();
        
        humanWorker = new HumanWorker();
        robotWorker = new RobotWorker();
        humanWorker.eat();
        humanWorker.work();
        robotWorker.work();
        //robotWorker.eat(); Salta la excepción
        
        avestruz = new Avestruz();
        //avestruz.volar(); Salta la excepción
        
        bombilla = new Bombilla();
        interruptorBombilla = new Interruptor(bombilla);
        bombilla.encender();
        bombilla.apagar();
        interruptorBombilla.operar();
    }
    
}
