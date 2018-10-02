package com.carllewisapps.notes.network;


import com.carllewisapps.notes.network.model.Note;
import com.carllewisapps.notes.network.model.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * This class holds the interface methods of
 * every defining endpoint
 */

public interface ApiService {

    //Register new user
    @FormUrlEncoded
    @POST("notes/user/register")
    Single<User> register(@Field("device_id") String deviceId);

    //Create note
    @FormUrlEncoded
    @POST("notes/new")
    Single<Note> createNote(@Field("note") String note);


    // Fecth all notes end point
    @GET("notes/all")
    Single<List<Note>> fetchAllNotes();

    //Update single note
    @FormUrlEncoded
    @PUT("notes/{id}")
    Completable updateNotes(@Path("id") int noteId, @Field("note") String note);

    // Delete note
    @DELETE
            ("notes/{id}")
    Completable deleteNote(@Path("id") int noteId);



}
