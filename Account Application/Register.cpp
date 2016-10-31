// Register.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"
#include "Register.h"
#include "Login.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CRegister dialog


CRegister::CRegister(CWnd* pParent /*=NULL*/)
	: CDialog(CRegister::IDD, pParent)
{
	//{{AFX_DATA_INIT(CRegister)
	m_strRegOKPassword = _T("");
	m_strRegPassword = _T("");
	m_strRegName = _T("");
	//}}AFX_DATA_INIT
}


void CRegister::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CRegister)
	DDX_Text(pDX, IDC_EDIT3, m_strRegOKPassword);
	DDX_Text(pDX, IDC_EDIT2, m_strRegPassword);
	DDX_Text(pDX, IDC_EDIT1, m_strRegName);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CRegister, CDialog)
	//{{AFX_MSG_MAP(CRegister)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CRegister message handlers

void CRegister::OnButton1() 
{
	//确定
	UpdateData(1);
	CString Filepath="TVXQ_Data.mdb";
	CString Sname,Spsw;
	_variant_t varname ,varpsw;
	CDaoRecordset DbSet(&TVXQ);
	TVXQ.Open(Filepath);
	DbSet.Open(AFX_DAO_USE_DEFAULT_TYPE,"SELECT * FROM DataTable",0);
	varname=DbSet.GetFieldValue("Name");
	varpsw=DbSet.GetFieldValue("Psw");
	Sname=(LPCSTR)_bstr_t(varname);
	Spsw=(LPCSTR)_bstr_t(varpsw);

	
	if(m_strRegName.IsEmpty()||m_strRegPassword.IsEmpty())
	{
		MessageBox("提示：信息不能为空","采花大豆·记账");
		m_strRegPassword="";
		m_strRegOKPassword="";
		m_strRegName="";
		UpdateData(0);
		DbSet.Close();
		TVXQ.Close();
		return;
	}


	while (!DbSet.IsEOF())
	{
		if (Sname!=m_strRegName)
		{
		varname=DbSet.GetFieldValue("Name");
    	varpsw=DbSet.GetFieldValue("Psw");
	    Sname=(LPCSTR)_bstr_t(varname);
    	Spsw=(LPCSTR)_bstr_t(varpsw);
		DbSet.MoveNext();
		}
		else
		{
			MessageBox("用户已经存在","采花大豆·记账");
		DbSet.Close();
		TVXQ.Close();
			m_strRegPassword="";
			m_strRegOKPassword="";
			m_strRegName="";
			UpdateData(0);
			return;
		}
	}

	if (DbSet.IsEOF())
	{
		//添加用户

		if (m_strRegOKPassword!=m_strRegPassword)
		{
			MessageBox("提示：两次输入的密码不一致！","采花大豆·记账");
			m_strRegPassword="";
			m_strRegOKPassword="";
			UpdateData(0);
		}
		else
		{
		DbSet.AddNew();
		DbSet.SetFieldValue("Name",_variant_t(m_strRegName));
		DbSet.SetFieldValue("Psw",_variant_t(m_strRegPassword));
		DbSet.Update();
		m_strRegName="";
		m_strRegPassword="";
		m_strRegOKPassword="";
		UpdateData(0);
		MessageBox("注册成功！","采花大豆·记账");
		}
					
		DbSet.Close();
		TVXQ.Close();
	}
}
