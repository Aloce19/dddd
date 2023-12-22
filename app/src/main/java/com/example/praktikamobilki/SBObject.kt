package com.example.praktikamobilki

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest

object SBObject {
    val users = createSupabaseClient(
        supabaseUrl = "https://oisdskvfhqclphsjrysl.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9pc2Rza3ZmaHFjbHBoc2pyeXNsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEyNTI0MzAsImV4cCI6MjAxNjgyODQzMH0.uXUm5JT7dlfmMAv3Qxnj-iaXlBDiQ9_9hyDeZ57xPcE"
    ){
        install(GoTrue)
        install(Postgrest)
    }
    public fun getClient(): SupabaseClient {
        return users
    }
}