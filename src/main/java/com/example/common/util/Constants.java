/*
 * FileName：Constants.java 
 * <p>
 * Copyright (c) 2017-2020, <a href="http://www.webcsn.com">hermit (794890569@qq.com)</a>.
 * <p>
 * Licensed under the GNU General Public License, Version 3 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/gpl-3.0.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author : hermit
 */

public class Constants {

	//200	请求成功
	//201	创建成功
	//400	错误的请求
	//401	未验证
	//403	被拒绝
	//404	无法找到
	//409	资源冲突
	//500	服务器内部错误
	//202   验证码失效
	
	public static final Integer CODE_ERROR = 202;
	public static final String MSG_CODE_ERROR = "验证码失效";
		/**
	 * 请求成功状态码
	 */
	public static final Integer SUCCESS = 200;

	/**
	 * 创建成功状态码
	 */
	public static final Integer SUCCESS_CREATE = 201;

	/**
	 * 错误的请求
	 */
	public static final Integer ERROR_SUCCESS = 400;

	/**
	 * 未验证
	 */
	public static final Integer ERROR_UNVAIL = 401;

	/**
	 * 被拒绝
	 */
	public static final Integer ERROR_REFUSE = 403;

	/**
	 * 无法找到
	 */
	public static final Integer ERROR_UNFOUNT = 404;

	/**
	 * 资源冲突
	 */
	public static final Integer ERROR_CONFLICT = 409;

	/**
	 * 内部错误
	 */
	public static final Integer ERRORT = 500;

	/**
	 * 成功提示
	 **/
	public static final String MSG_SUCCESS = "操作成功!";

	/**
	 * 操作失败提示
	 **/
	public static final String MSG_ERROR = "服务器开小差了....";
	/**
	 * 校验失败提示
	 **/
	public static final String MSG_ERROR_CHECK = "校验未通过";

	/**
	 * 校验成功提示
	 **/
	public static final String MSG_SUCCESS_CHECK = "校验通过";

	public enum role{
		Admin("Admin"),VIP("VIP"),PUBLIC("PUBLIC");

		private String value;

		role(String role) {
			this.value = role;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 常用状态值
	 */
	public enum state{

		ZERO("0"),ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6");

		private String value;

		state(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
