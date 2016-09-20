package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Flávio Coutinho <fegemo@gmail.com>
 */
public class Perseguir extends Algoritmo {

    private static final char NOME = 's';

    public Perseguir(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Perseguir(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 pos = agente.posicao;
        Vector3 alvo = new Vector3(this.alvo.getObjetivo());
        
        // Calcula a direção para onde o agente deve ir
        // Input: a posicao do objetivo (this.alvo) e deste agente
        // ..
        // ..
        // ..
        // ..
        // Output: vetor velocidade (apontando na direção encontrada) 
        //         limitado pela maxVelocidade (tangencial)
        // PS: não é necessário definir a rotação
        alvo = alvo.sub(pos);
        if(alvo.dst(0,0,0)==0){
            output.velocidade=alvo.sub(alvo);
            return output;
        }
        alvo = alvo.nor();
        alvo = alvo.scl(this.maxVelocidade);
        output.velocidade = alvo;
        
        //output.velocidade.nor();
       // output.velocidade.x = alvo.x - agente.posicao.x;
       //output.velocidade.y = alvo.y - agente.posicao.y;
       // output.velocidade.z = alvo.z - agente.posicao.z;
        
        return output;
    }

}
