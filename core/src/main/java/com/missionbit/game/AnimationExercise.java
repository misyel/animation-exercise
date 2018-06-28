package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

public class AnimationExercise extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Random randomSource;
    private Sprite myImage;
    private SpriteBatch myBatch;
    private Vector2 velocity;
    //private Dog dog;
    private ArrayList<Dog> dogs = new ArrayList<Dog>();
    //private ArrayList<Dog> smallDogs = new ArrayList<Dog>();


    @Override
    public void create() {
        randomSource = new Random();

        // Set up camera for 2d view of 800x480 pixels
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create a sprite batch for rendering our image
        myBatch = new SpriteBatch();

        //dog = new Dog(myBatch);

        for(int i = 0; i < 10; i++){
            Dog f = new Dog(myBatch);
            dogs.add(f);
        }

        /*

        for(int x = 0; x < 20; x++){
            Dog y = new Dog(myBatch);
            smallDogs.add(y);
        }
        */



        //TODO: Load our image
    }

    @Override
    public void render() {

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

        //TODO: Draw our image!

        //dog.update();

        myBatch.begin();
        //dog.draw();
        for(Dog f : dogs){
            f.update();
            f.draw();
        }
        myBatch.end();


        if(Gdx.input.isTouched()){
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            camera.unproject(touchPos);

            for(Dog f : dogs){
                f.handleClick(touchPos);
            }
        }
    }



    @Override
    public void dispose() {
        myBatch.dispose();
    }
}