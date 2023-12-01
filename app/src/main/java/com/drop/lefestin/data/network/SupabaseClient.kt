package com.drop.lefestin.data.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://ndefbaxquzwcbjcepffc.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5kZWZiYXhxdXp3Y2JqY2VwZmZjIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTY5NzE2NDIsImV4cCI6MjAxMjU0NzY0Mn0.jtPRy4cMMpkbuZpBwiQhlTQpBsVl611Xm72ygtZkyCY"
    ){
        install(Postgrest)
        install(GoTrue)
    }
}