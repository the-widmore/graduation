package com.ccniit.graduation.plus.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.ParamsLengthException;
import com.ccniit.graduation.exception.TemplateStructureUpdateException;
import com.ccniit.graduation.pojo.common.VoterGroupData;
import com.ccniit.graduation.pojo.db.Voter;
import com.ccniit.graduation.resource.SpringScope;
import com.ccniit.graduation.util.DateUtils;
import com.ccniit.graduation.util.LoggerUtils;
import com.ccniit.graduation.util.StreamUtils;
import com.ccniit.graduation.validator.StringVaildateFactory;
import com.ccniit.graduation.validator.StringVaildateFactory.StringVaildateType;

@Component("parseVotersFromExcel")
@Scope(SpringScope.SINGLETON)
public class ParseVotersFromExcel implements VoterParse {

	private static final int MAX_RECODE = 1002;

	private static final Logger DEV = LoggerUtils.getDev();
	private static final Logger ERR = LoggerUtils.getErr();

	@Resource
	StringVaildateFactory stringVaildateFactory;

	@Override
	public VoterGroupData parse(String... params) throws IException {
		if (1 != params.length) {
			throw new ParamsLengthException("参数个数错误！");
		}

		List<Voter> voters = new ArrayList<>();
		String voterGroupDescription = null;
		Voter voter = null;

		String excelPath = params[0];
		InputStream is = null;
		HSSFWorkbook workbook = null;
		try {
			is = new FileInputStream(excelPath);
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			DEV.error("Excel操作IO错误", e);
		}

		int numberOfSheet = workbook.getNumberOfSheets();

		if (1 != numberOfSheet) {
			throw new TemplateStructureUpdateException("联系人模版结构被改变！");
		}

		try {
			// get the first sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			if (null == sheet) {
				return null;
			}

			// 获取联系人组描述
			try {
				voterGroupDescription = sheet.getRow(0).getCell(1).getStringCellValue();
			} catch (NullPointerException e) {
				voterGroupDescription = DateUtils.y4M2d2(null);
			}

			// get voter ,begin with 3th row
			for (int rowNum = 2; rowNum <= MAX_RECODE; rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				if (row == null) {
					// 有空行，就结束
					break;
				}

				voter = new Voter();

				try {
					String email = row.getCell(0).getStringCellValue();

					// 如果邮箱格式不正确，抛弃该条数据
					if (!stringVaildateFactory.vaildate(StringVaildateType.EMAIL, email)) {
						continue;
					}
					voter.setEmail(email);

					// 电话
					HSSFCell phoneCell = row.getCell(1);
					if (null == phoneCell) {

					} else {
						double originalPhone = phoneCell.getNumericCellValue();
						String phone = com.ccniit.graduation.util.StringUtils.formatDecimal(originalPhone);
						// 电话格式正确才设值
						if (stringVaildateFactory.vaildate(StringVaildateType.PHONE, phone)) {
							voter.setPhone(phone);
						}
					}

					// 备注
					HSSFCell aliasCell = row.getCell(2);
					if (null == aliasCell) {
						// 无备注
						voter.setAlias(StringUtils.EMPTY);
					} else {
						String originalAlias = aliasCell.getStringCellValue();
						if (StringUtils.isNotBlank(originalAlias)) {
							String alias = com.ccniit.graduation.util.StringUtils.getLeftString(originalAlias, 10);
							voter.setAlias(alias);
						}
					}

				} catch (NullPointerException e) {
					continue;
				}

				DEV.debug(voter.toString());
				voters.add(voter);
			}
		} catch (Exception e) {
			ERR.error(e.getCause().getMessage(), e);
		} finally {
			StreamUtils.closeStream(workbook);
		}

		VoterGroupData voterGroupData = new VoterGroupData(voterGroupDescription, voters);

		return voterGroupData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
