package com.app.githubuserappsub1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.githubuserappsub1.adapter.DataUserAdapter
import com.app.githubuserappsub1.data.GithubUser
import com.app.githubuserappsub1.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parcelData =
            intent.getParcelableExtra<GithubUser>(DataUserAdapter.EXTRA_DATA) as GithubUser
        binding.nama.text = parcelData.name
        binding.idTvUsernameDetail.text = parcelData.username
        binding.idCompany.text = parcelData.company
        binding.idLocation.text = parcelData.location
        binding.idFollowerDetail.text = parcelData.follower.toString()
        binding.idFollowingDetail.text = parcelData.following.toString()
        binding.idRepo.text = parcelData.repo.toString()

        val source = resources.getIdentifier(parcelData.avatar, null, this.packageName)
        binding.imgDetailUser.setImageResource(source)
        supportActionBar?.title = "About"
    }
}