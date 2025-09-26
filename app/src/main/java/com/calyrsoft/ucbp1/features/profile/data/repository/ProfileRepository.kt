package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.CellphoneVO
import com.calyrsoft.ucbp1.features.profile.domain.model.EmailVO
import com.calyrsoft.ucbp1.features.profile.domain.model.ImageUrlVO
import com.calyrsoft.ucbp1.features.profile.domain.model.NameVO
import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.SummaryVO
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository

class ProfileRepository: IProfileRepository {
    override fun fetchData(): Result<ProfileModel> {
        return Result.success(
            ProfileModel(
                pathUrl = ImageUrlVO("https://randomuser.me/api/portraits/women/65.jpg"),
                name = NameVO("Sara Montenegro"),
                email = EmailVO("sara.montenegro@correoexample.com"),
                cellphone = CellphoneVO("+591 755-48239"),
                summary = SummaryVO("Ingeniera en telecomunicaciones con experiencia en aprendizaje automático.")
            )
        )
    }
}