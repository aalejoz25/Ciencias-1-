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
public class Arbol<E extends Comparable> {

    private Nodo<E> raiz;
    private Nodo<E> nuevo;

    public Arbol() {
        raiz = null;

    }

    public void InsercionRN(E datoRN) {

        Nodo<E> nodoaux = agregarNodo(datoRN);
        if (nodoaux.getPadre() == null) {
            nuevo = raiz;
        }
        try {
            if (nodoaux.getPadre().getHijoDerecho() == nodoaux) {
                nuevo = nodoaux.getPadre().getHijoDerecho();
            }
        } catch (NullPointerException e) {
        }
        try {
            if (nodoaux.getPadre().getHijoIzquierdo() == nodoaux) {
                nuevo = nodoaux.getPadre().getHijoIzquierdo();
            }
        } catch (NullPointerException e) {
        }

        //_______________________________________________________________
        
        
        
        
        
        //___________________________________________________
        
        
        
        
        nuevo.setColor("R");
        Nodo<E> p = nuevo.getPadre();
        do {
            try {
                if (p == nuevo.getPadre().getPadre().getHijoIzquierdo()) {
                Nodo<E> u = nuevo.getPadre().getPadre().getHijoDerecho();
                if ("R".equals(u.getColor())) {
                    p.setColor("N");
                    u.setColor("N");
                    nuevo.getPadre().getPadre().setColor("R");
                    nuevo = nuevo.getPadre().getPadre();
                    p = nuevo.getPadre();
                } else {
                    if (nuevo == p.getHijoDerecho()) {
                        nuevo = p;
                        RotacionIzquierda(nuevo);
                        p = p.getPadre();
                    }
                    nuevo.getPadre().setColor("N");
                    nuevo.getPadre().getPadre().setColor("R");
                    RotacionDerecha(nuevo.getPadre().getPadre());
                }
            } else {
                //hacer codigo simetrico *falta modificar
                Nodo<E> u = nuevo.getPadre().getPadre().getHijoIzquierdo();
                if ("R".equals(u.getColor())) {
                    p.setColor("N");
                    u.setColor("N");
                    nuevo.getPadre().getPadre().setColor("R");
                    nuevo = nuevo.getPadre().getPadre();
                    p = nuevo.getPadre();
                } else {
                    if (nuevo == p.getHijoIzquierdo()) {
                        nuevo = p;
                        RotacionDerecha(nuevo);
                        p = p.getPadre();
                    }
                    nuevo.getPadre().setColor("N");
                    nuevo.getPadre().getPadre().setColor("R");
                    RotacionIzquierda(nuevo.getPadre().getPadre());
                }
            }
            } catch (NullPointerException e) {
            }
            
        } while (raiz != nuevo && "R".equals(p.getColor()));

    }

    public void RotacionIzquierda(Nodo<E> x) {
        Nodo<E> y = x.getHijoDerecho();
        try {
            x.setHijoDerecho(y.getHijoIzquierdo());
        } catch (NullPointerException e) {
            x.setHijoDerecho(null);
        }
        try {
            if (y.getHijoIzquierdo() != null) {
                y.getHijoIzquierdo().setPadre(x);
                y.setPadre(x.getPadre());
            }
        } catch (NullPointerException e) {
        }

        if (x.getPadre() == null) {
            raiz = y;
        } else {
            if (x == x.getPadre().getHijoIzquierdo()) {
                x.getPadre().setHijoIzquierdo(y);
            } else {
                x.getPadre().setHijoDerecho(y);
            }
        }

        y.setHijoIzquierdo(x);
        x.setPadre(y);
    }

    public void RotacionDerecha(Nodo<E> y) {
        Nodo<E> x = y.getHijoIzquierdo();
        try {
            y.setHijoIzquierdo(x.getHijoDerecho());
        } catch (NullPointerException e) {
            y.setHijoIzquierdo(null);
        }
        try {
            if (y.getHijoDerecho() != null) {
                x.getHijoDerecho().setPadre(y);
                x.setPadre(y.getPadre());
            }
        } catch (NullPointerException e) {
        }

        if (y.getPadre() == null) {
            raiz = x;
        } else {
            if (y == y.getPadre().getHijoDerecho()) {
                y.getPadre().setHijoDerecho(x);
            } else {
                y.getPadre().setHijoIzquierdo(x);
            }
        }

        x.setHijoDerecho(y);
        y.setPadre(x);
    }

    public Nodo<E> agregarNodo(E dato) {
        if (raiz == null) {
            raiz = new Nodo<E>(dato, null);
            raiz.setColor("R");
            return raiz;
        } else {
            Nodo<E> nodo = raiz.agregarNodo(dato);
            return nodo;
        }

    }

    public Nodo<E> getRaiz() {
        return raiz;
    }
    
    

}
