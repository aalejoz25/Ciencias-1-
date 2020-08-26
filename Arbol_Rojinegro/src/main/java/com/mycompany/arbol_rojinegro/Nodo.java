/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbol_rojinegro;

/**
 *
 * @author Alvaro
 */
public class Nodo<E extends Comparable> {

    private E dato;
    private String color;
//false=negro
//true=rojo
    private Nodo<E> hijoIzquierdo, hijoDerecho;
    private Nodo<E> padre;

    public Nodo(E d, Nodo<E> padre) {
        this.dato = d;
        this.padre = padre;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public Nodo<E> agregarNodo(E d) {

        if (d.compareTo(dato) >= 0) {
            if (hijoDerecho.getDato() == null) {
                hijoDerecho = new Nodo<E>(d, this);
                Nodo<E> nill = new Nodo(null, hijoDerecho);
                nill.setColor("Negro");
                hijoDerecho.hijoDerecho = nill;
                hijoDerecho.hijoIzquierdo = nill;
                return hijoDerecho;
            } else {

                return hijoDerecho.agregarNodo(d);

            }
        } else {
            if (hijoIzquierdo.getDato() == null) {
                hijoIzquierdo = new Nodo<E>(d, this);
                Nodo<E> nill = new Nodo(null, hijoDerecho);
                nill.setColor("Negro");
                hijoIzquierdo.hijoDerecho = nill;
                hijoIzquierdo.hijoIzquierdo = nill;
                return hijoIzquierdo;
            } else {
                return hijoIzquierdo.agregarNodo(d);
            }
        }
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo<E> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo<E> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo<E> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo<E> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void recorrerIRD() {
        try {
            hijoIzquierdo.recorrerIRD();
        } catch (Exception e) {
        }
        System.out.println(dato);
        try {
            hijoDerecho.recorrerIRD();
        } catch (Exception e) {
        }
    }
    
    public void recorrerDRI() {
        try {
            hijoDerecho.recorrerDRI();
        } catch (Exception e) {
        }
        System.out.println(dato);
        try {
            hijoIzquierdo.recorrerDRI();
        } catch (Exception e) {
        }
    }

    public void recorrerRID() {
        System.out.println(dato);
        try {
            hijoIzquierdo.recorrerRID();
        } catch (Exception e) {
        }

        try {
            hijoDerecho.recorrerRID();
        } catch (Exception e) {
        }
    }

    public void recorrerRDI() {
        System.out.println(dato);
        try {
            hijoDerecho.recorrerRDI();
        } catch (Exception e) {
        }

        try {
            hijoIzquierdo.recorrerRDI();
        } catch (Exception e) {
        }
    }

    public Nodo<E> buscarNodomenor() {
        if (this.hijoIzquierdo.getDato() == null) {
            return this;
        } else {
            return this.hijoIzquierdo.buscarNodomenor();
        }

    }

    public Nodo<E> buscarNodomayor() {
        if (this.getDato().compareTo(this.getPadre().getDato()) <= 0) {
            return this.getPadre();
        } else {
            return this.getPadre().buscarNodomayor();
        }

    }

}
