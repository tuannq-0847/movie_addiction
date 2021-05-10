package com.example.movieaddiction.ui.composables.screen

import android.content.Context
import android.net.Uri
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHostController
import com.example.movieaddiction.R
import com.example.movieaddiction.model.BaseMovieResponse
import com.example.movieaddiction.model.MovieVideo
import com.example.movieaddiction.ui.composables.viewmodels.HomeViewModel
import com.example.movieaddiction.utils.Constant
import com.example.movieaddiction.utils.Karl
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.karleinstein.basemvvm.extension.addFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(
    navHostController: NavHostController,
    fragmentManager: FragmentManager
) {
    val homeViewModel = getViewModel<HomeViewModel>()

    homeViewModel.test()
    val data: BaseMovieResponse<MovieVideo> by homeViewModel.movieResponse.observeAsState(
        BaseMovieResponse()
    )

    AndroidView(factory = {
        YouTubePlayerView(it).apply {
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            getPlayerUiController()
            enterFullScreen()
            toggleFullScreen()
            addYouTubePlayerListener(object : YouTubePlayerListener {
                override fun onApiChange(youTubePlayer: YouTubePlayer) {

                }

                override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {

                }

                override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {

                }

                override fun onPlaybackQualityChange(
                    youTubePlayer: YouTubePlayer,
                    playbackQuality: PlayerConstants.PlaybackQuality
                ) {

                }

                override fun onPlaybackRateChange(
                    youTubePlayer: YouTubePlayer,
                    playbackRate: PlayerConstants.PlaybackRate
                ) {

                }

                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo("k3StqDN36G0",0F)
                    Karl.d("data: $data")
                }

                override fun onStateChange(
                    youTubePlayer: YouTubePlayer,
                    state: PlayerConstants.PlayerState
                ) {

                }

                override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {

                }

                override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {

                }

                override fun onVideoLoadedFraction(
                    youTubePlayer: YouTubePlayer,
                    loadedFraction: Float
                ) {

                }
            })
        }
    })
}
