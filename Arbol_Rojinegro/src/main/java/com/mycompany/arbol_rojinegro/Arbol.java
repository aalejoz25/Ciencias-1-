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

    public void InsertarNodo(E datoRN) {

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

        if (nuevo != raiz) {
            nuevo.setColor("Rojo");
        }
        try {
            if (!"Negro".equals(nuevo.getPadre().getColor())) {
                Nodo<E> p = nuevo.getPadre();

                do {
                    try {

                        if (p == nuevo.getPadre().getPadre().getHijoIzquierdo()) {
                            Nodo<E> u = nuevo.getPadre().getPadre().getHijoDerecho();
                            if ("Rojo".equals(u.getColor())) {
                                p.setColor("Negro");
                                u.setColor("Negro");
                                nuevo.getPadre().getPadre().setColor("Rojo");
                                nuevo = nuevo.getPadre().getPadre();
                                p = nuevo.getPadre();
                            } else {
                                if (nuevo == p.getHijoDerecho()) {
                                    nuevo = p;
                                    RotacionIzquierda(nuevo);
                                    System.out.println("Se ha rotado a la izquierda en: " + nuevo.getDato());
                                    p = p.getPadre();
                                }
                                nuevo.getPadre().setColor("Negro");
                                nuevo.getPadre().getPadre().setColor("Rojo");
                                RotacionDerecha(nuevo.getPadre().getPadre());
                                System.out.println("Se ha rotado a la derecha en: " + nuevo.getDato());
                            }
                        } else {

                            Nodo<E> u = nuevo.getPadre().getPadre().getHijoIzquierdo();
                            if ("Rojo".equals(u.getColor())) {
                                p.setColor("Negro");
                                u.setColor("Negro");
                                nuevo.getPadre().getPadre().setColor("Rojo");
                                nuevo = nuevo.getPadre().getPadre();
                                p = nuevo.getPadre();
                            } else {
                                if (nuevo == p.getHijoIzquierdo()) {
                                    nuevo = p;
                                    RotacionDerecha(nuevo);
                                    System.out.println("Se ha rotado a la derecha en: " + nuevo.getDato());
                                    p = p.getPadre();
                                }
                                nuevo.getPadre().setColor("Negro");
                                nuevo.getPadre().getPadre().setColor("Rojo");
                                RotacionIzquierda(nuevo.getPadre().getPadre());
                                System.out.println("Se ha rotado a la izquierda en: " + nuevo.getPadre().getPadre().getDato());
                            }
                        }
                    } catch (NullPointerException e) {
                    }

                } while (raiz != nuevo && "Rojo".equals(p.getColor()));
            }
        } catch (NullPointerException e) {
        }

        raiz.setColor("Negro");

    }

    private void RotacionIzquierda(Nodo<E> x) {
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

    private void RotacionDerecha(Nodo<E> y) {
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

    private Nodo<E> agregarNodo(E dato) {

        if (raiz == null) {
            Nodo<E> nill = new Nodo(null, raiz);
            nill.setColor("Negro");
            raiz = new Nodo<E>(dato, null);
            raiz.setHijoDerecho(nill);
            raiz.setHijoIzquierdo(nill);
            raiz.setColor("Rojo");
            return raiz;
        } else {
            Nodo<E> nodo = raiz.agregarNodo(dato);
            return nodo;
        }

    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void recorrerIRD() {
        raiz.recorrerIRD();
    }

    public void recorrerDRI() {
        raiz.recorrerDRI();
    }

    public void recorrerRID() {
        raiz.recorrerRID();
    }

    public void recorrerRDI() {
        raiz.recorrerRDI();
    }

    public Nodo<E> buscarNodo(E d, Nodo<E> r) {
        if (raiz == null) {
            return null;
        } else if (r.getDato().compareTo(d) == 0) {
            return r;
        } else if (r.getDato().compareTo(d) > 0) {
            return buscarNodo(d, r.getHijoIzquierdo());
        } else if (r.getDato().compareTo(d) < 0) {
            return buscarNodo(d, r.getHijoDerecho());
        }
        return null;
    }

    public void EliminarNodo(E dato) {
        Nodo<E> x = new Nodo(null, null);
        Nodo<E> y = new Nodo(null, null);
        Nodo<E> z = buscarNodo(dato, raiz);
        if (z.getHijoIzquierdo().getDato() == null | z.getHijoDerecho().getDato() == null) {
            y = z;
        } else {
            y = buscarSucesor(z);
        }
        if (y.getHijoIzquierdo().getDato() != null) {
            x = y.getHijoIzquierdo();
        } else {
            x = y.getHijoDerecho();
        }
        x.setPadre(y.getPadre());
        if (y.getPadre() == null) {
            raiz = x;
        } else {
            if (y == y.getPadre().getHijoIzquierdo()) {
                y.getPadre().setHijoIzquierdo(x);
            } else {
                y.getPadre().setHijoDerecho(x);
            }
        }
        if (y != z) {
            z.setDato(y.getDato());
        }
        if ("Negro".equals(y.getColor())) {
            //ajustar supresion
            ajustarSupresion(x);
        }
    }

    public void ajustarSupresion(Nodo<E> x) {
        Nodo<E> w = new Nodo(null, null);
        try {
            do {
                if (x == x.getPadre().getHijoIzquierdo()) {
                    w = x.getPadre().getHijoDerecho();
                    if ("Rojo".equals(w.getColor())) {
                        w.setColor("Negro");
                        x.getPadre().setColor("Rojo");
                        RotacionIzquierda(x.getPadre());
                        System.out.println("Se ha rotado a la izquierda en: " + x.getPadre().getDato());
                        w = x.getPadre().getHijoDerecho();
                    }
                    if ("Negro".equals(w.getHijoDerecho().getColor()) && "Negro".equals(w.getHijoIzquierdo().getColor())) {
                        w.setColor("Rojo");
                        x = x.getPadre();
                    } else {
                        if (w.getHijoDerecho().getColor() == "Negro") {
                            w.getHijoIzquierdo().setColor("Negro");
                            w.setColor("Rojo");
                            RotacionDerecha(w);
                            System.out.println("Se ha rotado a la derecha en: " + w.getDato());
                            w = x.getPadre().getHijoDerecho();
                        }
                    }
                    w.setColor(x.getPadre().getColor());
                    x.getPadre().setColor("Negro");
                    w.getHijoDerecho().setColor("Negro");
                    RotacionIzquierda(x.getPadre());
                    System.out.println("Se ha rotado a la izquierda en: " + x.getPadre().getDato());
                    x = raiz;
                } else {

                    w = x.getPadre().getHijoIzquierdo();
                    if ("Rojo".equals(w.getColor())) {
                        w.setColor("Negro");
                        x.getPadre().setColor("Rojo");
                        RotacionDerecha(x.getPadre());
                        System.out.println("Se ha rotado a la derecha en: " + x.getPadre().getDato());
                        w = x.getPadre().getHijoIzquierdo();
                    }
                    if ("Negro".equals(w.getHijoIzquierdo().getColor()) && "Negro".equals(w.getHijoDerecho().getColor())) {
                        w.setColor("Rojo");
                        x = x.getPadre();
                    } else {
                        if (w.getHijoIzquierdo().getColor() == "Negro") {
                            w.getHijoDerecho().setColor("Negro");
                            w.setColor("Rojo");
                            RotacionIzquierda(w);
                            System.out.println("Se ha rotado a la izquierda en: " + w.getDato());
                            w = x.getPadre().getHijoIzquierdo();
                        }
                    }
                    w.setColor(x.getPadre().getColor());
                    x.getPadre().setColor("Negro");
                    w.getHijoIzquierdo().setColor("Negro");
                    RotacionDerecha(x.getPadre());
                    System.out.println("Se ha rotado a la derecha en: " + x.getPadre().getDato());
                    x = raiz;

                }
            } while (x != raiz && "Negro".equals(x.getColor()));
        } catch (NullPointerException e) {
        }

        x.setColor("Negro");
    }

    public Nodo<E> buscarSucesor(Nodo<E> nodo) {
        try {
            Nodo<E> sucesor = new Nodo(null, null);

            if (nodo.getHijoDerecho().getDato() != null) {
                if (nodo.getHijoDerecho().getHijoIzquierdo().getDato() == null) {
                    sucesor = nodo.getHijoDerecho();
                } else {
                    //buscar el menor del subarbol derecho
                    sucesor = nodo.getHijoDerecho().buscarNodomenor();
                }
            } else {
                sucesor = nodo.buscarNodomayor();

            }
            return sucesor;

        } catch (NullPointerException e) {
        }
        return null;

    }

}
