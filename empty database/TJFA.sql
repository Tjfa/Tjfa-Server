-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 26, 2014 at 04:58 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `TJFA`
--

-- --------------------------------------------------------

--
-- Table structure for table `Competition`
--

CREATE TABLE IF NOT EXISTS `Competition` (
  `competitionId` int(32) NOT NULL AUTO_INCREMENT COMMENT '赛事id',
  `isStart` smallint(5) NOT NULL DEFAULT '0' COMMENT '赛事是否开始 0未开始的赛事 1正在进行中 2已经结束',
  `name` varchar(400) COLLATE utf8_bin NOT NULL COMMENT '赛事的名字  如  足协杯',
  `number` int(32) NOT NULL COMMENT '第几届比赛',
  `time` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '赛事时间 20131与20132表示第一学期和第二学期',
  `type` int(10) NOT NULL COMMENT '1 表示本部 2表示 嘉定',
  PRIMARY KEY (`competitionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Match`
--

CREATE TABLE IF NOT EXISTS `Match` (
  `matchId` int(32) NOT NULL AUTO_INCREMENT COMMENT '比赛ID',
  `date` datetime NOT NULL COMMENT '比赛时间  如 2014年6月5日 12:15',
  `isStart` smallint(5) NOT NULL COMMENT '是否开始 0表示 没有开始  1或者2表示结束',
  `matchProperty` smallint(5) NOT NULL COMMENT '比赛性质 0:小组赛  1:决赛 2:半决赛 4:1/4 8:1/8 16:1/16 32:1/32 100：附加赛 ',
  `scoreA` int(32) NOT NULL COMMENT '比分 第一支球队的得分',
  `scoreB` int(32) NOT NULL COMMENT '比分 第二只球队的得分',
  `winTeamId` int(32) NOT NULL COMMENT '获胜队伍的 id',
  `competitionId` int(32) NOT NULL COMMENT '所属赛事的 id',
  `teamAId` int(32) NOT NULL COMMENT '参赛的第一支球队 对应scoreA',
  `teamBId` int(32) NOT NULL COMMENT '参赛的第二支球队 对应scoreB',
  PRIMARY KEY (`matchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `News`
--

CREATE TABLE IF NOT EXISTS `News` (
  `newsId` int(32) NOT NULL AUTO_INCREMENT COMMENT 'newsId',
  `title` varchar(400) COLLATE utf8_bin NOT NULL COMMENT '新闻标题',
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT '新闻内容 直接换成html文件 我们第一版先不做图片功能了',
  `date` date NOT NULL COMMENT '发布日期',
  `precontent` varchar(1000) COLLATE utf8_bin NOT NULL COMMENT '新闻预览内容，纯文本 没有大小',
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Player`
--

CREATE TABLE IF NOT EXISTS `Player` (
  `playerId` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) COLLATE utf8_bin NOT NULL COMMENT '球员名字',
  `goalCount` int(32) NOT NULL COMMENT '球员进球数 用来统计射手榜',
  `redCard` int(32) NOT NULL COMMENT '红牌数量 罚款用的',
  `yellowCard` int(32) NOT NULL COMMENT '黄牌数量 罚款',
  `teamId` int(32) NOT NULL COMMENT '所属于的球队  如果一个人同时在两个球队 那么我们创建2个球员',
  `competitionId` int(32) NOT NULL COMMENT '所属赛事',
  PRIMARY KEY (`playerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Team`
--

CREATE TABLE IF NOT EXISTS `Team` (
  `teamId` int(32) NOT NULL AUTO_INCREMENT COMMENT '对应的赛事id',
  `emblemPath` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '队徽的地址 可以使用时间hash',
  `groupGoalCount` int(32) NOT NULL COMMENT '小组赛进球',
  `groupMissCount` int(32) NOT NULL COMMENT '小组赛失球',
  `goalCount` int(32) NOT NULL COMMENT '进球数',
  `missCount` int(32) NOT NULL COMMENT '失球数',
  `groupNo` int(32) NOT NULL COMMENT '所在小组  a b c d ',
  `name` varchar(400) COLLATE utf8_bin NOT NULL COMMENT '队伍名字',
  `score` int(32) NOT NULL COMMENT '小组赛积分 胜3 平1 输0',
  `competitionId` int(32) NOT NULL COMMENT '所属于的赛事 ',
  `rank` int(32) NOT NULL COMMENT '最高排名  1234 前4名   8 八强  16 16强 0小组赛 100附加赛',
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
