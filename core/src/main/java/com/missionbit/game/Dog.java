package com.missionbit.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Dog {

    private Sprite myImage;
    private Vector2 velocity;
    private SpriteBatch myBatch;
    private ParticleEffect effect;
    private Sprite effectImg;
    private TextureAtlas textureAtlas;

    public Dog(SpriteBatch batch){
        myBatch = batch;
        myImage = new Sprite( new Texture(Gdx.files.internal("images/dog.png")));
        velocity = new Vector2(MathUtils.random() * 300, MathUtils.random() * 300);
        effect = new ParticleEffect();
        //effectImg = new Sprite(new Texture(Gdx.files.internal("images/dogEffect")));
        textureAtlas = new TextureAtlas();
        //effect.load(Gdx.files.internal("images/effect.p"), textureAtlas);

    }

    public void update(){
        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();

        myImage.setX(xPos);
        myImage.setY(yPos);

        if(myImage.getX() < 0){
            myImage.setX(0);
            velocity.x *= -1;
            //velocity.y*=-1;
        }
        else if(myImage.getY() < 0){
            myImage.setY(0);
            //velocity.x *= 1;
            velocity.y*=-1;
        }
        else if(myImage.getX()+myImage.getWidth()>Gdx.graphics.getWidth() ){
            myImage.setX(Gdx.graphics.getWidth() -myImage.getWidth());
            velocity.x*=-1;
        }
        else if(myImage.getY()+myImage.getHeight()>Gdx.graphics.getHeight() ){
            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
            //velocity.x*=-1;
            velocity.y*=-1;
        }
    }

    public boolean handleClick(Vector3 touchPos){
        if(Gdx.input.isTouched()){
            if(myImage.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.input.getY())) {
                //myImage.setColor(1, 0, 0, 1);
                myImage.setSize(50,50);
                //effect.setPosition(Gdx.input.getX(),Gdx.input.getY());
                //effect.start();
                return true;
            }
        }
        return false;  // We can return true if we're clicked on
    }

    public void draw(){
        myImage.draw(myBatch);
        //effect.draw(myBatch);
    }
}
