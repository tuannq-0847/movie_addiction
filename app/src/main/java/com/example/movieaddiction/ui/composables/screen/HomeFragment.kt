package com.example.movieaddiction.ui.composables.screen

import com.example.movieaddiction.R
import com.example.movieaddiction.databinding.FragmentHomeBinding
import com.karleinstein.basemvvm.base.BaseFragment
import com.karleinstein.basemvvm.utils.viewBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    override val viewBinding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun bindView() {
        viewBinding.videoPlayer.addYouTubePlayerListener(object : YouTubePlayerListener{
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

    override fun setUpView() {
        viewBinding.videoPlayer.getPlayerUiController()
        viewBinding.videoPlayer.enterFullScreen()
        viewBinding.videoPlayer.toggleFullScreen()
    }

}