package com.example.web.api;


import com.example.common.response.ResponseVo;
import com.example.common.util.Constants;
import com.example.common.util.IdWorker;
import com.example.domain.Power;
import com.example.domain.vo.PowerVo;
import com.example.service.PowerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private PowerService powerService;

    @PostMapping(value = "insertPower")
    public ResponseVo insertPower(PowerVo powerVo){

        Power power = new Power();

        BeanUtils.copyProperties(powerVo,power);

        try {
            powerService.insert(power);
            return new ResponseVo().setCode(Constants.SUCCESS).setMsg(Constants.MSG_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseVo().setCode(Constants.ERRORT).setMsg(Constants.MSG_ERROR);
        }
    }

}

