package com.check.shaditestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.fragment_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileFragment : BaseFragment(), CardStackListener {

    companion object {
        fun getInstance(): ProfileFragment {

            return ProfileFragment()
        }
    }


    private lateinit var mLayoutManager: CardStackLayoutManager
    private var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_profile, container, false)
        }
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getProfileResponse()
        mLayoutManager = CardStackLayoutManager(requireContext(),this)
        setupButton()

    }

    private fun getProfileResponse() {
        val call = (requireActivity() as MainActivity).getRetrofit()?.getProfileList()
        call?.enqueue(object : Callback<ProfileListResponse> {
            override fun onResponse(call: Call<ProfileListResponse>, response: Response<ProfileListResponse>) {
                if (response.code() == AppConstant.HTTP_OK) {
                        onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<ProfileListResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }



    private fun onFailure(throwable: Throwable) {
        Toast.makeText(requireContext(),"throwable",Toast.LENGTH_LONG).show()
    }

    private fun onSuccess(profileListResponse: ProfileListResponse) {
        initialize(profileListResponse.results)
        Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
    }

    private fun setData() {

    }

    private fun initialize(results: List<ProfileShadi?>?) {
        mLayoutManager.setStackFrom(StackFrom.None)
        mLayoutManager.setVisibleCount(3)
        mLayoutManager.setTranslationInterval(8.0f)
        mLayoutManager.setScaleInterval(0.95f)
        mLayoutManager.setSwipeThreshold(0.3f)
        mLayoutManager.setMaxDegree(20.0f)
        mLayoutManager.setDirections(Direction.HORIZONTAL)
        mLayoutManager.setCanScrollHorizontal(true)
        mLayoutManager.setCanScrollVertical(true)
        mLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        mLayoutManager.setOverlayInterpolator(LinearInterpolator())

        card_stack_view.layoutManager = mLayoutManager
        card_stack_view.adapter = CardStackAdapter(results)
        card_stack_view.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    private fun setupButton() {
        dislike_button.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            mLayoutManager.setSwipeAnimationSetting(setting)
            card_stack_view.swipe()
        }

        star_button.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            mLayoutManager.setRewindAnimationSetting(setting)
            card_stack_view.rewind()
        }

        like_button.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            mLayoutManager.setSwipeAnimationSetting(setting)
            card_stack_view.swipe()
        }
    }

}