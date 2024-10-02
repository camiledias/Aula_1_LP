/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package camile_32;


import java.util.ArrayList;
import java.util.List;

class Carro {
    private String marca;
    private String nome;
    public Carro(String marca, String nome) {
      this.marca = marca;
      this.nome = nome;
    }
    protected String nomeCompleto() {
      return marca + " " + nome;
    }
    public void andar() {
      System.out.println("O carro " + nomeCompleto() + " está andando");
    }
  }

public class Camile_32 {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla");

        // Irá exibir "O carro Toyota Corolla está andando".
        carro.andar();
        
        Caminhao caminhao = new Caminhao("Mercedes", "1318", 16);
        // O caminhão Mercedes 1318 carrega 16 toneladas
        caminhao.mostraCarga();
        
        Bomba bomba = new Bomba("Gasolina");
        bomba.abastecer(new Carro("Fiat", "Gol")); // O Carro Fiat Gol está sendo abastecido com Gasolina
        
        Posto posto = new Posto(3);
        caminhao = new Caminhao("Mercedes", "1318", 16);

        try {
            Bomba bombaDisponivel = posto.bombaDisponivel();
            bombaDisponivel.abastecer(caminhao);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
  

class Caminhao extends Carro {
    private int carga;
    public Caminhao(String marca, String nome, int carga) {
        super(marca, nome);
        this.carga = carga;
    }
     
    public void mostraCarga() {
        System.out.println("O caminhão " + super.nomeCompleto() +
        " carrega " + carga + " toneladas");
    }

    public void andar() {
        System.out.println("O caminhão " + super.nomeCompleto() +
        " está carregando " + carga + " toneladas");
    }
    public void andar(boolean deRe) {
        if (deRe)
            System.out.println("O caminhão " + super.nomeCompleto() +
            " está carregando " + carga + " toneladas de ré");
        else
            andar();
    }
}
class Bomba {
    private String combustivel;
    private Carro carroAbastecendo;
    public Bomba(String combustivel) {
        this.combustivel = combustivel;
    }
    public void abastecer(Carro carro) {
        this.carroAbastecendo = carro;
        System.out.println("O " + carro.getClass().getSimpleName() + " " + carro.nomeCompleto () + " está sendo abastecido com " + this.combustivel);
    }
    public boolean estaDisponivel() {
        return this.carroAbastecendo == null;
    }
}

class Posto {
    private List<Bomba> bombas;
    public Posto(int numBombas) {
        bombas = new ArrayList<Bomba>();
        for (int i = 0; i < numBombas; i++) {
            bombas.add(new Bomba("Diesel"));
        }
    }
    public Bomba bombaDisponivel() throws Exception {
        for (Bomba bomba : bombas) {
            if (bomba.estaDisponivel()) {
                return bomba;
            }
        }
        throw new Exception("Nenhuma bomba disponível");
    }
}